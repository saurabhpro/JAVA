package Ch07_Object_Oriented_Design.Q7_11_File_System;

abstract class Entry {
    private final Directory parent;
    private final long created;
    private long lastUpdated;
    private long lastAccessed;
    private String name;

    Entry(String n, Directory p) {
        name = n;
        parent = p;
        created = System.currentTimeMillis();
    }

    public boolean delete() {
        return parent != null && parent.deleteEntry(this);
    }

    protected abstract int size();

    public String getFullPath() {
        if (parent == null) {
            return name;
        } else {
            return parent.getFullPath() + "/" + name;
        }
    }

    public long getCreationTime() {
        return created;
    }

    public long getLastUpdatedTime() {
        return lastUpdated;
    }

    public long getLastAccessedTime() {
        return lastAccessed;
    }

    public void changeName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }
}
