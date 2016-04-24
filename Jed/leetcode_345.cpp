
#include <string>
#include <vector>
#include <iostream>
#include <stdio.h>
#include <algorithm>
using namespace std;

#if 1
/*Write a function that takes a string as input and reverse only the vowels of a string.
vowels: a, e,i,o,u
*/
void swap(char* src,char* dst)
{
	char tmp;
	tmp = *src;
	*src = *dst;
	*dst = tmp;
}

bool isMatch(char src)
{
	if (src =='a'|| src =='e'||src=='i'||src=='o'||src=='u'
     || src == 'A' || src == 'E' || src == 'I' || src == 'O' || src == 'U')
	{
		return true;
	}
	else
	{
		return false;
	}
}
string reverseVowels(string s)
{
	string str = s;
	size_t len = s.length();
	int i = 0, j = len - 1;
	while (i<j)
	{
		if (!isMatch(str[i]))
		{
			i++;
			continue;
		}
		if (!isMatch(str[j]))
		{
			j--;
			continue;
		}

		swap(&str[i],&str[j]);
		i++;
		j--;

	}
	return str;
}

int main()
{
	string str = "hello";//"leetcode";
	string rst = reverseVowels(str);
	cout << rst << endl;
	getchar();
}
#endif

/*-----------------------------提交的代码---------------------------------------*/
class Solution {
public:
    string reverseVowels(string s) {
        string str = s;
	    int len = str.length();
	    int i = 0, j = len - 1;
	    char tmp;
    	while (i<j)
	    {
	    	if (!(str[i]=='a'|| str[i] =='e'||str[i]=='i'||str[i]=='o'||str[i]=='u'||
	    	     str[i]=='A'|| str[i] =='E'||str[i]=='I'||str[i]=='O'||str[i]=='U'))
	    	{
	    		i++;
	    		continue;
	    	}
	    	if (!(str[j]=='a'|| str[j] =='e'||str[j]=='i'||str[j]=='o'||str[j]=='u'||
	    	      str[j]=='A'|| str[j] =='E'||str[j]=='I'||str[j]=='O'||str[j]=='U'))
	    	{
	    		j--;
		    	continue;
	    	}

	    	tmp = str[i];
	    	str[i] = str[j];
	    	str[j]=tmp;
	    	i++;
	    	j--;

    	}
    	return str;
    }
};
