/*
1002. д������� (20)

ʱ������
400 ms
�ڴ�����
65536 kB
���볤������
8000 B
�������
Standard
����
CHEN, Yue
����һ����Ȼ��n���������λ����֮�ͣ��ú���ƴ��д���͵�ÿһλ���֡�

�����ʽ��ÿ�������������1��������������������Ȼ��n��ֵ�����ﱣ֤nС��10100��

�����ʽ����һ�������n�ĸ�λ����֮�͵�ÿһλ��ƴ�����ּ���1 �ո񣬵�һ�������һ��ƴ�����ֺ�û�пո�

����������
1234567890987654321123456789
���������
yi san wu
*/


#include<iostream>
#include<stack>
using namespace std;
string num2pinyin[] = { "ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu" };
stack<int> stk;
int main()
{
	string input;
	cin >> input;
	int sum = 0;
	for (int i = 0; i<input.size(); i++)
	{
		sum += input[i] - '0';
	}

	int n = sum;
	while (n)
	{
		stk.push(n % 10);
		n /= 10;
	}
	int len = stk.size();
	while (len--)
	{
		if (len != 0)
		{
			cout << num2pinyin[stk.top()] << " ";
			stk.pop();
		}
		else
		{
			cout << num2pinyin[stk.top()];
			stk.pop();
		}

	}
	return 0;
}