package datalayer.store

import java.io.*
import java.util.*

/**
 * Created by Zahar on 04.05.16.
 */
class FileStoreImpl(private val fileName: String) : LocalStore {

	override fun <T> saveList(arr: List<T>) {
		val fout = FileOutputStream (fileName);
		val oos = ObjectOutputStream(fout);
		oos.writeObject(arr);
		fout.close();
	}

	override fun<T> readList(): MutableList<T> {
		var fin: FileInputStream? = null
		val ois: ObjectInputStream
		try {
			fin = FileInputStream (fileName)
			ois = ObjectInputStream(fin);
			@Suppress("UNCHECKED_CAST")
			return ois.readObject() as MutableList<T>;
		} catch(e: Exception) {
			return Collections.emptyList()
		} finally {
			fin?.close();
		}
	}

	override fun removeList() {
		File(fileName).delete()
	}
}

