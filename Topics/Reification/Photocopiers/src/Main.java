/**
 * Class to work with
 */
class Multiplicator {

	public static <T extends Copy<T>> Folder<T>[] multiply(Folder<T> folder, int arraySize) {

        Folder<T>[] folders = new Folder[arraySize];
        final T t = folder.get().copy();
        for (int i = 0; i < arraySize; i++) {
            final Folder<T> tFolder = new Folder<>();
            tFolder.put(t);
            folders[i] = tFolder;
        }

        return folders;
    }

}

// Don't change the code below
interface Copy<T> {
	T copy();
}

class Folder<T> {

    private T item;

    public void put(T item) {
    	this.item = item;
    }

    public T get() {
        return this.item;
    }
}