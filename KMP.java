package algorithms;

public class KMP
{
	StringBuffer S;
	StringBuffer T;
	int tLen;
	int sLen;
	int[] next;

	public KMP(String s, String t)
	{
		S = new StringBuffer('#' + s);
		T = new StringBuffer('#' + t);
		tLen = t.length();
		sLen = s.length();
		next = new int[tLen + 10];
	}

	void getNext()
	{
		int i = 1;
		int j = 0;
		next[1] = 0;
		while (i <= tLen)
		{
			if (j == 0 || T.charAt(i) == T.charAt(j))
			{
				++i;
				++j;
				next[i] = j;
				
			} else
			{
				j = next[j];
			}

		}
	}

	int match()
	{
		getNext();
		int i = 1, j = 1; // index of first element is 1
		while (i <= sLen && j <= tLen)
		{
			if (j == 0 || S.charAt(i) == T.charAt(j))
			{
				++i;
				++j;
			} 
			else
				j = next[j];
		}
		if (j > tLen)
			return i - tLen - 1;// find a match
		else
			return -1;
	}

}
