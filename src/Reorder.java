// 重排序
// 升序数组 <=
// 变换
// fx（i）
// 一元二次方程
// o(n)
// ax2 + bx + c
public class Reorder {
    public static void main(String[] args) {
        double[] A = new double[]{-100,-6,-3,-2,-1,0,1,2,3,4,5};

        // double[] A = new double[]{-5};
        //double[] A = new double[]{};
        // double a = 1.0;
        // double b = 0.0;
        // double c = 0.0;

        double a = -1.0;
        double b = -1.0;
        double c = 0.0;

        // double a = 0.0;
        // double b = 3.0;
        // double c = 1.0;

        double[] res = new Reorder().fn(A, a, b, c);
        for(double d:res){
            System.out.print(d + " ");
        }

    }

    double[] fn(double A[], double a, double b, double c) {
        if(A == null || A.length == 0){
            return A;
        }

        int n = A.length;

        // ax + b = 0
        double x = -b / a;
        int idx = -1;
        if (a != 0.0) {
            x = -b / a;
            idx = find(A, x);
        }

        for (int i = 0; i < n; i++) {
            A[i] = a * A[i] * A[i] + b * A[i] + c;
        }

        if (a == 0.0 && b == 0.0) {
            return A;
        }

        if (a == 0.0) {
            if (b > 0) {
                return A;
            } else {
                // reverse the array
                reverse(A, 0, A.length - 1);
                return A;
            }
        }

        if (a > 0.0) {
            reverse(A, 0, idx);
        } else {
            reverse(A, idx + 1, n - 1);
        }

        if (idx <= 0 || idx >= n - 1) {
            return A;
        }

        return merge(A, idx);
    }

    double[] merge(double[] A, int idx) {
        int i1 = 0;
        int i2 = idx + 1;
        double[] res = new double[A.length];

        int k = 0;
        while (k < A.length) {
            if (i1 > idx || i2 >= A.length) {
                break;
            }

            if (A[i1] < A[i2]) {
                res[k] = A[i1++];
            } else {
                res[k] = A[i2++];
            }

            k++;
        }

        if (i1 <= idx) {
            while (i1 <= idx) {
                res[k] = A[i1++];
                k++;
            }
        }

        if (i2 < A.length) {
            while (i2 < A.length) {
                res[k] = A[i2++];
                k++;
            }
        }

        return res;
    }

    // 找到极值的index
    int find(double A[], double x) {
        int idx = 0;
        while (idx < A.length && A[idx] < x) {
            idx++;
        }
        return idx - 1;

    }

    void reverse(double A[], int l, int r) {
        if (A == null || A.length == 0) {
            return;
        }
        if (l >= r) {
            return;
        }
        if (l >= A.length || r <= 0) {
            return;
        }

        for (int i = l, j = r; i < j; i++, j--) {
            double tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
}
