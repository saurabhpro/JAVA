# MyRowSet — running the demos

The demos under `MyRowSet/Types/` connect to an Oracle DB at
`jdbc:oracle:thin:@localhost:1521/FREE` with user `system` and password
`98989`. Bring up a local Oracle FREE container, seed a couple of tables, run
the demo.

## 1. Start Oracle Free in Docker

```bash
docker run -d --name oracle-free \
  -p 1521:1521 \
  -e ORACLE_PASSWORD=98989 \
  gvenzl/oracle-free:slim
```

Wait until the log says `DATABASE IS READY TO USE`:

```bash
docker logs -f oracle-free
```

Service name is `FREE` (not the legacy SID `orcl`). The demos already use
`jdbc:oracle:thin:@localhost:1521/FREE` — keep that connection string when
running locally.

## 2. Seed the schema

Connect with SQL\*Plus inside the container:

```bash
docker exec -it oracle-free sqlplus system/98989@//localhost:1521/FREE
```

Then run:

```sql
CREATE TABLE emp (
  emp_id     NUMBER,
  emp_fname  VARCHAR2(50),
  emp_lname  VARCHAR2(50),
  emp_dob    DATE,
  emp_salary NUMBER
);

INSERT INTO emp VALUES (1, 'Sam',   'Smith', DATE '1987-11-24', 6400);
INSERT INTO emp VALUES (2, 'Kevin', 'Patel', DATE '1990-02-10', 7100);

CREATE TABLE person (
  p_fname VARCHAR2(50),
  p_lname VARCHAR2(50),
  accno   NUMBER
);

CREATE TABLE bank (
  accno  NUMBER,
  income NUMBER
);

INSERT INTO person VALUES ('Sam',   'Smith', 1001);
INSERT INTO bank   VALUES (1001, 50000);

COMMIT;
EXIT;
```

`emp` is enough for `CachedRowSetDemo`, `WebRowSetDemo`, `JdbcRowSetDemo`,
`FilteredRowSetDemo`. `person` + `bank` are required for `JoinRowSetDemo`.

## 3. Run a demo

From repo root:

```bash
cd JavaCon/JDBC
mvn -q compile exec:java \
    -Dexec.mainClass="MyRowSet.Types.CachedRowSetDemo" \
    -Dexec.classpathScope="compile"
```

Swap the main class for the demo you want:

| Demo                    | Main class                              |
|-------------------------|-----------------------------------------|
| Cached, serialised RS   | `MyRowSet.Types.CachedRowSetDemo`       |
| WebRowSet → XML         | `MyRowSet.Types.WebRowSetDemo`          |
| Connected JDBC RowSet   | `MyRowSet.Types.JdbcRowSetDemo`         |
| Filter via Predicate    | `MyRowSet.Types.FilteredRowSetDemo`     |
| Join two CachedRowSets  | `MyRowSet.Types.JoinRowSetDemo`         |

In IntelliJ: open the demo, right-click → **Run**.

## 4. Output files

`CachedRowSetDemo` writes the serialised rowset to
`${java.io.tmpdir}/cached_rowset.bin`, and `WebRowSetDemo` writes the XML
dump to `${java.io.tmpdir}/emp.xml`. Inspect with:

```bash
ls "$(printf '%s' "$TMPDIR")cached_rowset.bin" "$(printf '%s' "$TMPDIR")emp.xml"
```

## 5. Tear down

```bash
docker stop oracle-free && docker rm oracle-free
```

## Troubleshooting

- **`ORA-12541: Cannot connect. No listener…`** — container not up or port
  not mapped. Re-check `docker ps` and the `-p 1521:1521` flag.
- **`ORA-01017: invalid credential`** — `ORACLE_PASSWORD` env var differs
  from the demo's hardcoded `98989`. Either rerun the container with the
  expected value or change the demo.
- **`ORA-00942: table or view does not exist`** — schema seeding step (2)
  was skipped or pointed at the wrong PDB. Verify with
  `SELECT table_name FROM user_tables;`.
- **First container start takes minutes** — Oracle initialises the PDB on
  first boot. Subsequent restarts are fast because data lives in the
  container's volume.
