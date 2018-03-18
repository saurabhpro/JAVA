package com.saurabh.stringQ;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * String util/library class.
 */
public final class Strings {
	public static final String SEPARATOR_ARRAY_DEFAULT = ",";                        // NOPMD
	private static Logger sLog = Logger.getLogger(Strings.class.getName());

	private Strings() {
		// nobody should ever instantiate an object of this class
	}

	public static int length(String iString) {
		return iString.length();
	}

	/**
	 * Returns a new string that is a substring of this string.
	 * <p>
	 * B#2413# 0-based
	 * </p>
	 * <b>0-based index parameter</b>
	 *
	 * @see String#substring(int, int)
	 */
	public static String substr(String iString, int iFrom, int iLen) {
		String r;
		if (iFrom > iString.length()) {
			r = "";
		} else {
			if (iLen < 0) {
				r = iString.substring(iFrom);
			} else {
				int length = iFrom + iLen;
				if (length > iString.length()) {
					length = iString.length();
				}
				r = iString.substring(iFrom, length);
			}
		}
		return r;
	}

	public static char getFillerCharacter(String strFiller) {
		char r = ' ';
		if (strFiller.length() > 0) {
			r = strFiller.charAt(0);
		}
		return r;
	}

	private static String padLeftRight(String iString, String strFiller, int iLen, boolean right) {
		char chrFiller;
		String oString;
		int len;
		StringBuffer stringBuffer;

		len = iString.length();
		if (len < iLen) {
			chrFiller = getFillerCharacter(strFiller);
			stringBuffer = new StringBuffer();

			if (right) {
				stringBuffer.append(iString);
			}
			for (int i = 0; i < iLen - len; i++) {
				stringBuffer.append(chrFiller);
			}
			if (!right) {
				stringBuffer.append(iString);
			}
			oString = stringBuffer.toString();
		} else {
			oString = iString;
		}
		return oString;
	}

	private static String trimLeftRight(String iString, String strFiller, boolean right) {
		String string = iString;
		if (string == null) {
			string = "";
		}
		String r = string;
		int len = string.length() - 1;
		int offSet = 0;
		char chrFiller;
		chrFiller = getFillerCharacter(strFiller);
		if (!right && len >= 0 && string.charAt(0) == chrFiller) {
			for (; offSet <= len; offSet++) {
				if (string.charAt(offSet) != chrFiller) {
					break;
				}
			}
		}
		if (right && len >= offSet && string.charAt(len) == chrFiller) {
			for (; len >= offSet; len--) {
				if (string.charAt(len) != chrFiller) {
					len++;
					break;
				}
			}
		} else {
			len++; // No trailing chars
		}
		if (offSet > 0 || len < string.length()) {
			if (len < 0) {
				len = 0;
			}
			r = string.substring(offSet, len);
		}
		return r;
	}

	public static String padLeft(String iString, String strFiller, int iLen) {
		return padLeftRight(iString, strFiller, iLen, false);
	}

	public static String padRight(String iString, String strFiller, int iLen) {
		return padLeftRight(iString, strFiller, iLen, true);
	}

	public static String trimLeft(String iString, String strFiller) {
		return trimLeftRight(iString, strFiller, false);
	}

	public static String trimRight(String iString, String strFiller) {
		return trimLeftRight(iString, strFiller, true);
	}

	public static int toInt(String iString) {
		int r = 0;
		if (iString != null && !iString.trim().isEmpty()) {
			try {
				r = Integer.parseInt(iString);
			} catch (NumberFormatException e) {
				throw new RuntimeException("sys.ErrorNumberFormat");
			}
		}
		return r;
	}

	/**
	 * Ignore parsing exception and use default value instead.
	 *
	 * @param iString
	 * @param iDefaultValue
	 * @return
	 */
	public static int toIntWithDefault(String iString, int iDefaultValue) {
		int r = iDefaultValue;
		if (!Strings.isEmpty(iString)) {
			try {
				r = Integer.parseInt(iString);
			} catch (NumberFormatException e) {
				// do nothing
			}
		}
		return r;
	}

	public static double toFloat(String iString) {
		double r = 0.0;

		if (iString != null && !iString.trim().isEmpty()) {
			try {
				r = Double.parseDouble(iString);
			} catch (NumberFormatException e) {
				throw new RuntimeException("sys.ErrorFloatFormat");
			}
		}
		return r;
	}

	/*
	public static double toFloatUsingLocale(String iString) {
		double r = 0.0;

		if (iString != null && !iString.trim().isEmpty()) {
			Localizer localizer = LocalizerFactory.getLocalizer();
			try {
				r = localizer.parseNumber(iString);
			} catch (ParseException e) {
				throw StdReturnException.makeStdReturnException(e, null, "sys.ErrorFloatFormat");
			}
		}
		return r;
	}*/

	/**
	 * Ignore parsing exception and use default value instead.
	 *
	 * @param iString
	 * @param iDefaultValue
	 * @return
	 */
	public static double toFloatWithDefault(String iString, double iDefaultValue) {
		double r = iDefaultValue;
		if (!Strings.isEmpty(iString)) {
			try {
				r = Double.parseDouble(iString);
			} catch (NumberFormatException e) {
				// do nothing
			}
		}
		return r;
	}

	public static String fromInt(int iInt, String iFormat) {
		String rv = null;
		// TODO not yet implemented!
		// OWIL impl.: char *s = StrOwForm(format, (int)iInt);

		if ("%d".equals(iFormat)) {
			rv = Integer.toString(iInt);
		} else if ("%02d".equals(iFormat)) {
			rv = Integer.toString(iInt);
			if (rv.length() < 2) {
				rv = "0" + rv; // NOPMD
			}
		} else {
			//rv = new PrintfFormat(iFormat).sprintf(iInt);
			if (sLog.isLoggable(Level.CONFIG)) {
				sLog.log(Level.INFO, "new PrintfFormat(\"" + iFormat + "\").sprintf(\"" + iInt + "\") = \"" + rv + "\"");
			}
		}
		return rv;
	}

	/**
	 * Replace any occurances of the <code>iSearchStr</code> with <code>iReplaceStr</code>.
	 *
	 * @param iStr        text to search and replace in
	 * @param iSearchStr  the string to search for
	 * @param iReplaceStr the string to replace with
	 * @return the text with any replacements processed
	 */
	public static String replaceSubStrings(String iStr, String iSearchStr, String iReplaceStr) {
		return StringUtils.replace(iStr, iSearchStr, iReplaceStr, -1);
	}

	/*
	private static String fromNumeric(double iNumeric, int iKomma, boolean iMoney, Localizer iLoc) {
		String r = null;

		if (iLoc != null) {
			if (iMoney) {
				r = iLoc.formatMoney(iNumeric, iKomma);
			} else {
				r = iLoc.formatNumber(iNumeric, iKomma);
			}

		} else {
			// TODO implement iMoney
			StringBuffer format = new StringBuffer("0");
			if (iKomma > 0) {
				format.append('.');
				for (int i = 0; i < iKomma; i++) {
					format.append('0');
				}
			}

			DecimalFormat df = new DecimalFormat(format.toString());
			r = df.format(iNumeric);
		}
		return r;

	}

*/

	/**
	 * creates a String from the float number. use a dynamic localizer for formating.
	 *
	 * @param iNumeric the float number to convert
	 * @param iKomma   the number of internal decimal places
	 * @param iMoney   represents number a money field
	 * @return the number as text
	 */
//	public static String fromNumeric(double iNumeric, int iKomma, boolean iMoney) {
//		return fromNumeric(iNumeric, iKomma, iMoney, LocalizerFactory.getLocalizer());
//	}

	/**
	 * creates a String from the float number use a static localizer for formating (always the same format, independent of the actual locale)
	 *
	 * @param iNumeric the float number to convert
	 * @param iKomma   the number of internal decimal places
	 * @param iMoney   represents number a money field
	 * @return the number as text
	 */
//	public static String fromNumericStd(double iNumeric, int iKomma, boolean iMoney) {
//		return fromNumeric(iNumeric, iKomma, iMoney, TemplateUtils.getStringifyLoc());
//	}

	/**
	 * Split a given String with iSearchString.
	 *
	 * @param iStr
	 * @param iSearchStr
	 * @param iReturnSearch whether to return also the iSearchStr.
	 * @return the array containing all the substrings.
	 */
	public static String[] split(String iStr, String iSearchStr, boolean iReturnSearch) {
		String[] rv = null;
		String tmp = iStr;
		int lastIndex = 0;
		ArrayList<String> list = new ArrayList<String>();
		int lenSearch = iSearchStr.length();
		if (iStr != null) {
			while (StringUtils.contains(tmp, iSearchStr)) {
				int idx = tmp.indexOf(iSearchStr);
				String cur = tmp.substring(0, idx);
				list.add(cur);
				if (iReturnSearch) {
					list.add(iSearchStr);
				}
				lastIndex = idx + lenSearch;
				tmp = tmp.substring(lastIndex);
			}
			if (tmp != null && tmp.length() > 0) {
				list.add(tmp);
			}
			rv = new String[list.size()];
			rv = list.toArray(rv);
		}
		return rv;
	}

	/**
	 * Split a given String after count chars.
	 *
	 * @param iStr
	 * @param count
	 * @return the array containing all the substrings.
	 */
	public static String[] splitAfter(String iStr, int count) {
		String[] ret = null;
		if (iStr != null) {
			if (count <= 0) {
				throw new IllegalArgumentException("count must be > 0");
			}
			int len = (int) java.lang.Math.ceil(((double) iStr.length()) / count);
			ret = new String[len];
			for (int index = 0; index < len; index++) {
				int start = index * count;
				int end = java.lang.Math.min((index + 1) * count, iStr.length());
				ret[index] = iStr.substring(start, end);
			}
		}
		return ret;
	}

	/**
	 * Split a given String with iSearchString.
	 *
	 * @param iStr
	 * @param iSearchStr
	 * @return the list containing the not empty substrings.
	 */
	public static ArrayList<String> splitNotEmpty(String iStr, String iSearchStr) {
		ArrayList<String> rv = new ArrayList<String>();

		String[] activityArray = split(iStr, iSearchStr, false);
		if (activityArray != null && activityArray.length > 0) {
			int size = activityArray.length;
			for (int idx = 0; idx < size; idx++) {
				if (activityArray[idx] != null && !isEmpty(activityArray[idx].trim())) {
					rv.add(activityArray[idx].trim());
				}
			}
		}

		return rv;

	}

	/**
	 * Check whether it's a whole word.
	 *
	 * @param iCheck
	 * @param iPrev
	 * @param iNext
	 * @return
	 */
	public static boolean isWholeWord(String iCheck, String iPrev, String iNext) {
		boolean r;
		r = iPrev == null || iPrev.length() == 0 || !Character.isLetterOrDigit(iPrev.charAt(iPrev.length() - 1));
		if (r) {
			r = iNext == null || iNext.length() == 0 || !Character.isLetterOrDigit(iNext.charAt(0));
		}
		return r;
	}

	/**
	 * Check whether it only consists of [a-zA-Z0-9]
	 *
	 * @param iCheck
	 * @return
	 */
	public static boolean isAlnum(String iCheck) {
		int len = iCheck.length();
		boolean r = true;

		for (int i = 0; i < len; i++) {
			if (!Character.isLetterOrDigit(iCheck.charAt(i))) {
				r = false;
				break;
			}
		}
		return r;
	}

	/**
	 * Returns the index within iString of the first occurrence of the specified substring.
	 *
	 * @param iString
	 * @param iSubString
	 * @return the 0-based index of the given substring or -1 if not found
	 * @see String#indexOf(java.lang.String)
	 */
	public static int findIndex(String iString, String iSubString) {
		int r = -1;
		if (iString != null && iSubString != null) {
			r = iString.indexOf(iSubString);
		}
		return r;
	}

	/**
	 * Returns the index within this string of the first occurrence of the specified substring, starting at the specified index.
	 *
	 * @param iString
	 * @param iSub
	 * @param iFromIndex
	 * @return the index of the given iSub string
	 * @see String#indexOf(java.lang.String, int)
	 */
	public static int indexOf(String iString, String iSub, int iFromIndex) {
		int rv = -1;
		if (iString != null) {
			rv = iString.indexOf(iSub, iFromIndex);
		}
		return rv;
	}

	/**
	 * Tests if this string starts with the specified prefix.
	 *
	 * @param iString
	 * @param iPrefix
	 * @return whether the given iString starts with iPrefix.
	 * @see String#startsWith(java.lang.String)
	 */
	public static boolean startsWith(String iString, String iPrefix) {
		boolean r = false;
		if (iString != null) {
			r = iString.startsWith(iPrefix);
		}
		return r;
	}

	/**
	 * <p>
	 * Counts how many times the substring appears in the larger string.
	 * </p>
	 *
	 * @param iStr the string to check
	 * @param iSub the substring to count
	 * @return the number of occurances.
	 * @see StringUtils#countMatches(CharSequence, char)
	 */
	public static int countMatches(String iStr, String iSub) {
		int rv;
		rv = StringUtils.countMatches(iStr, iSub);
		return rv;
	}

	/**
	 * replace all occurrences of oldString in iString with oldString
	 *
	 * @see StringUtils#replace(java.lang.String, java.lang.String, java.lang.String)
	 */
	public static String replace(String iString, String oldString, String newString) {
		String r = iString;
		if (iString != null && oldString != null && newString != null) {
			r = StringUtils.replace(iString, oldString, newString);
		}
		return r;
	}

	/**
	 * Create a <code>String</code> representation of the given array-elements.
	 *
	 * @param iToString  <code>Object</code>-array which elements to print out
	 * @param ioSb
	 * @param iSeparator
	 * @return ioSb
	 */
	public static StringBuffer arrayToString(final Object[] iToString, final String iSeparator, final StringBuffer ioSb) {
		if (iToString != null) {
			for (int i = 0, cnt = iToString.length; i < cnt; i++) {
				ioSb.append(iToString[i]);
				if (i < cnt - 1) {
					ioSb.append(iSeparator);
				}
			}
		}
		return ioSb;
	}

	public static StringBuffer arrayToString(final Object[] iToString, final StringBuffer ioSb) {
		return arrayToString(iToString, SEPARATOR_ARRAY_DEFAULT, ioSb);
	}

	public static String arrayToString(Object[] iToString, String iSeparator) {
		final StringBuffer sb = new StringBuffer();
		arrayToString(iToString, iSeparator, sb);
		return sb.toString();
	}

	public static String arrayToString(Object[] iToString) {
		return arrayToString(iToString, SEPARATOR_ARRAY_DEFAULT);
	}

	/**
	 * replaces iSearchStr with iReplaceWith in iStr
	 *
	 * @param iStr         the sql string
	 * @param iSearchStr   the search string (table)
	 * @param iReplaceWith the replace string (table)
	 * @return the replaced string
	 * @deprecated replaceTableMapping does not create parse statements correctly, use class TableMapper instead
	 */
	public static String replaceTableMapping(final String iStr, String iSearchStr, String iReplaceWith) {
		StringBuffer r = new StringBuffer();
		String parts[] = StringUtils.split(iStr, ' ');
		if (parts.length == 0) {
			r.append(iStr);
		} else {
			for (int i = 0; i < parts.length; i++) {
				final String token = parts[i];
				if (token.indexOf(iReplaceWith) == -1) {
					if (isWordMatch(token, iSearchStr)) {
						parts[i] = StringUtils.replace(parts[i], iSearchStr, iReplaceWith);
					} else {
						sLog.info("won't replace [" + iSearchStr + "] in [" + parts[i] + "] with: [" + iReplaceWith + "]");
					}
					// } else {
					/*
					 * diesen Teil nicht ersetzen
					 */
				}
				r.append(parts[i]);
				if (i != (parts.length - 1)) {
					r.append(' ');
				}
			}
		}
		return r.toString();
	}

	/**
	 * Check whether the searchstring is contained in iStr as a full word.
	 *
	 * @param iStr       must not be null
	 * @param iSearchStr must not be null
	 * @deprecated only checks the first occurance of iSearchStr
	 */
	private static boolean isWordMatch(final String iStr, final String iSearchStr) {
		boolean rv;
		rv = (iStr.equals(iSearchStr));
		if (!rv && iStr.length() > iSearchStr.length()) {
			int startIdx = iStr.indexOf(iSearchStr);
			if (startIdx > 0) {
				String prefix = iStr.substring(0, startIdx);
				prefix = prefix.substring(prefix.length() - 1, prefix.length());
				rv = !StringUtils.isAlphanumeric(prefix);
			} else {
				rv = true;
			}
			if (rv) {
				String suffix = iStr.substring(startIdx + iSearchStr.length(), startIdx + iSearchStr.length() + 1);
				rv = !StringUtils.isAlphanumeric(suffix);
			}
		}
		return rv;
	}

	public static String trimRight(String iString) {
		String string = iString;
		if (string == null) {
			string = "";
		}
		String r = string;
		int len = string.length() - 1;
		if (len >= 0 && string.charAt(len) == ' ') {
			for (; len >= 0; len--) {
				if (string.charAt(len) != ' ') {
					len++;
					break;
				}
			}
			r = string.substring(0, len >= 0 ? len : 0);
		}
		return r;
	}

	public static boolean isEmpty(String iString) {
		boolean r = true;
		if (iString != null && iString.length() > 0) {
			char[] chars = iString.toCharArray();
			for (char c : chars) {
				if (c != ' ') {
					r = false;
					break;
				}
			}
		}
		return r;
	}

	// NOPMD
	public static String toLower(String iString) {
		//String r = iString.toLowerCase(DefaultLocale.forCase());
		String r = iString.toLowerCase();
		if (r.length() != iString.length()) {
			char[] chars = iString.toCharArray();
			for (int i = 0; i < chars.length; ++i) {
				chars[i] = Character.toLowerCase(chars[i]);
			}
			r = new String(chars);
		}
		return r;
	}

	// NOPMD
	public static String toUpper(String iString) {
		String r = iString.toUpperCase();
		if (r.length() != iString.length()) {
			char[] chars = iString.toCharArray();
			for (int i = 0; i < chars.length; ++i) {
				chars[i] = Character.toUpperCase(chars[i]);
			}
			r = new String(chars);
		}
		return r;
	}

	// NOPMD
	public static String toLowerText(String iString) {
		return iString.toLowerCase();
	}

	// NOPMD
	public static String toUpperText(String iString) {
		return iString.toUpperCase();
	}

	/**
	 * Concatenate a list of strings to a single one. Nulls are omitted.
	 *
	 * @param strings The list of strings to put together to one.
	 * @return The concatenated string, or an empty string if the input was empty or null.
	 */
	public static String concat(String... strings) {
		StringBuffer ret = new StringBuffer();
		if (strings != null) {
			for (String s : strings) {
				if (s != null) {
					ret.append(s);
				}
			}
		}
		return ret.toString();
	}

	@SuppressWarnings("squid:S1166")
	public static String toMD5Hash(String iString) {
		String r = null;

		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(iString.getBytes("ISO-8859-1"));
			byte digest[] = m.digest();

			BigInteger bigInt = new BigInteger(1, digest);
			r = bigInt.toString(16);
			// Now we need to zero pad it if you actually want the full 32
			// chars.
			while (r.length() < 32) {
				r = "0" + r; // NOPMD
			}
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException nsae) {
			// do nothing
		}
		return r;
	}

	public static String escapeCsv(final String str, char separator) {
		return escapeCsv(str, String.valueOf(separator));
	}

	public static String escapeCsv(final String str, String separator) {
		String r = str;
		if (str != null) {
			boolean enclose = false;
			if (0 <= str.indexOf('\"')) {
				enclose = true;
				r = str.replace("\"", "\"\"");
			}
			enclose = enclose || (0 <= str.indexOf(separator));
			enclose = enclose || (0 <= str.indexOf('\n'));
			if (enclose) {
				r = "\"" + r + "\"";
			}
		}
		return r;
	}

	public static int cmp(String s1, String s2) {
		return s1.compareTo(s2);
	}

	public static String unicodeChar(int codePoint) {
		return String.valueOf(Character.toChars(codePoint));
	}

}