#include <iostream>
using namespace std;

typedef struct
{
	int left;
	int rigth;
	int maxSum;
}MAX_SUM_STRU;

MAX_SUM_STRU croosMidMaxArray(int a[], int left, int right)
{
	int leftmax = 0xffffffff;
	int mid = (left + right) >> 1;
	int sum = 0;
	MAX_SUM_STRU maxRst;
	int i;
	for (i = mid; i >= left; i--)
	{
		sum += a[i];
		if (leftmax < sum)
		{
			leftmax = sum;
			maxRst.left = i;
		}
	}
	sum = 0;
	int rightmax = 0xffffffff;
	for (i = mid + 1; i <= right; i++)
	{
		sum += a[i];
		if (rightmax < sum)
		{
			rightmax = sum;
			maxRst.rigth = i;
		}
	}
	maxRst.maxSum = leftmax + rightmax;
	return maxRst;
}

MAX_SUM_STRU maxSubArray(int a[], int left, int right)
{
	MAX_SUM_STRU tmp = { 0 };
	if (left == right)
	{
		tmp.maxSum = a[left];
		return tmp;
	}
	else
	{
		int mid = (left + right) >> 1;
		MAX_SUM_STRU tmpleft = maxSubArray(a, left, mid);
		MAX_SUM_STRU tmpright = maxSubArray(a, mid + 1, right);
		MAX_SUM_STRU crossMax = croosMidMaxArray(a, left, right);

		if (tmpleft.maxSum >= tmpright.maxSum && tmpleft.maxSum>= crossMax.maxSum)
		{
			return tmpleft;
		}
		else if (tmpright.maxSum >= tmpleft.maxSum && tmpright.maxSum >= crossMax.maxSum)
		{
			return tmpright;
		}
		else
		{
			return crossMax;
		}

	}
}


int main()
{
	int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	MAX_SUM_STRU  rstMaxSubArray = maxSubArray(a, 0, sizeof(a) / sizeof(a[0]) - 1);
	cout << rstMaxSubArray.maxSum<<" "<< rstMaxSubArray.left<<" "<< rstMaxSubArray.rigth << endl;
	getchar();
	return 0;
}
