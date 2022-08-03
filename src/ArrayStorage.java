import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        boolean resumeDeleted = false;
        for (int i = 0; i < size; i++) {
            if (!resumeDeleted && storage[i].uuid.equals(uuid)) {
                resumeDeleted = true;
            }
            if (resumeDeleted) {
                if (i + 1 == size) {
                    storage[i] = null;
                } else {
                    storage[i] = storage[i + 1];
                }
            }
        }
        if (resumeDeleted) {
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
