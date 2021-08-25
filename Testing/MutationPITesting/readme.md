
- to run the pi test run the mvn test command

```bash
1:22:29 am PIT >> INFO : Incremental analysis reduced number of mutations by 0
1:22:29 am PIT >> INFO : Created  1 mutation test units in pre scan
1:22:29 am PIT >> INFO : Sending 2 test classes to minion
1:22:29 am PIT >> INFO : Sent tests to minion
1:22:29 am PIT >> INFO : MINION : 1:22:29 am PIT >> INFO : Checking environment
1:22:29 am PIT >> INFO : MINION : 1:22:29 am PIT >> INFO : Found  4 tests
1:22:29 am PIT >> INFO : MINION : 1:22:29 am PIT >> INFO : Dependency analysis reduced number of potential tests by 0
1:22:29 am PIT >> INFO : MINION : 1:22:29 am PIT >> INFO : 4 tests received
|1:22:29 am PIT >> INFO : Calculated coverage in 0 seconds.
1:22:29 am PIT >> INFO : Incremental analysis reduced number of mutations by 0
1:22:29 am PIT >> INFO : Created  1 mutation test units
/1:22:30 am PIT >> INFO : Completed in 1 seconds
================================================================================
- Mutators
================================================================================
> org.pitest.mutationtest.engine.gregor.mutators.BooleanTrueReturnValsMutator
>> Generated 2 Killed 2 (100%)
> KILLED 2 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.ConditionalsBoundaryMutator
>> Generated 1 Killed 0 (0%)
> KILLED 0 SURVIVED 1 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.IncrementsMutator
>> Generated 2 Killed 2 (100%)
> KILLED 2 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.MathMutator
>> Generated 3 Killed 3 (100%)
> KILLED 3 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.BooleanFalseReturnValsMutator
>> Generated 2 Killed 2 (100%)
> KILLED 2 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.NegateConditionalsMutator
>> Generated 5 Killed 5 (100%)
> KILLED 5 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
================================================================================
- Timings
================================================================================
> pre-scan for mutations : < 1 second
> scan classpath : < 1 second
> coverage and dependency analysis : < 1 second
> build mutation tests : < 1 second
> run mutation analysis : < 1 second
--------------------------------------------------------------------------------
> Total  : 1 seconds
--------------------------------------------------------------------------------
================================================================================
- Statistics
================================================================================
>> Line Coverage: 20/20 (100%)
>> Generated 15 mutations Killed 14 (93%)
>> Mutations with no coverage 0. Test strength 93%
>> Ran 20 tests (1.33 tests per mutation)
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.853 s
[INFO] Finished at: 2021-08-26T01:22:30+05:30
[INFO] ------------------------------------------------------------------------

```