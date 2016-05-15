package datalayer.store

interface LocalStore {
	open fun <T> saveList(arr: List<T>)
	open fun <T> readList(): MutableList<T>
	open fun removeList()
}