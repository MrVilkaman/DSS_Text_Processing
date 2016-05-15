package domain.providers

/**
 * Created by Zahar on 15.05.16.
 */
interface TextDP {

	open fun getRawText():String
	open fun getRawTextTitle(): String
	open fun getTextLink(): String
}