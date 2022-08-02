/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int storageSize = size();
        int i = 0;
        while (i < storageSize) {
            storage[i] = null;
            i++;
        }
    }

    void save(Resume r) {
        int storageSize = size();
        int i = 0;
        while (i < storageSize) {
            i++;
        }
        storage[i] = r;
    }

    Resume get(String uuid) {
        int storageSize = size();
        int i = 0;
        while (i < storageSize) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
            i++;
        }
        return null;
    }

    void delete(String uuid) {
        int storageSize = size();
        boolean resumeDeleted = false;
        int i = 0;
        while (i < storageSize) {
            if (storage[i].uuid.equals(uuid)) {
                resumeDeleted = true;
                break;
            }
            i++;
        }
        if (resumeDeleted) {
            while (i < storageSize) {
                if (i + 1 == storageSize) {
                    storage[i] = null;
                } else {
                    storage[i] = storage[i + 1];
                }
                i++;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int storageSize = size();
        Resume[] storageForReturn = new Resume[storageSize];
        int i = 0;
        while (i < storageSize) {
            storageForReturn[i] = storage[i];
            i++;
        }
        return storageForReturn;
    }

    int size() {
        int i = 0;
        while (i < storage.length && storage[i] != null) {
            i++;
        }
        return i;
    }
}
