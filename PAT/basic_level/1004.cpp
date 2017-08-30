/*
1004. �ɼ����� (20)

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
����n��ѧ����������ѧ�š��ɼ����ֱ�����ɼ���ߺͳɼ����ѧ����������ѧ�š�

�����ʽ��ÿ�������������1��������������ʽΪ

��1�У�������n
��2�У���1��ѧ�������� ѧ�� �ɼ�
��3�У���2��ѧ�������� ѧ�� �ɼ�
... ... ...
��n+1�У���n��ѧ�������� ѧ�� �ɼ�
����������ѧ�ž�Ϊ������10���ַ����ַ������ɼ�Ϊ0��100֮���һ�����������ﱣ֤��һ�����������û������ѧ���ĳɼ�����ͬ�ġ�
�����ʽ����ÿ�������������2�У���1���ǳɼ����ѧ����������ѧ�ţ���2���ǳɼ����ѧ����������ѧ�ţ��ַ�������1�ո�

����������
3
Joe Math990112 89
Mike CS991301 100
Mary EE990830 95
���������
Mike CS991301
Joe Math990112
*/


#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;

typedef struct
{
	string name;
	string studyNo;
	int scored;
}STUDENT_STRU;

bool ComareScore(const STUDENT_STRU&st1, const STUDENT_STRU&st2)
{
	return st1.scored < st2.scored;
}
vector<STUDENT_STRU> vcSt;
int main()
{
	int students;
	string name, studyNo;
	int scored;

	cin >> students;
	while (students--)
	{
		STUDENT_STRU stTemp;
		cin >> name >> studyNo >> scored;
		stTemp.name = name;
		stTemp.studyNo = studyNo;
		stTemp.scored = scored;

		vcSt.push_back(stTemp);
	}

	sort(vcSt.begin(), vcSt.end(), ComareScore);

	STUDENT_STRU stLow, stHigh;
	vector<STUDENT_STRU>::iterator it = vcSt.begin();
	stLow = *it;
	it = vcSt.end() - 1;
	stHigh = *it;

	cout << stHigh.name << " " << stHigh.studyNo << endl;
	cout << stLow.name << " " << stLow.studyNo << endl;


	return 0;
}