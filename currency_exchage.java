public class currency_exchage {
    int n;
    int[] currency;
    int[] count;

    public currency_exchage(int n) {
        this.n = n;
        currency = new int[n];
        count = new int[n];
    }

    public void addcurrency(int[] c, int[] cnt) {

        for (int i = 0; i < c.length; i++) {

            currency[i] = c[i];
            count[i] = cnt[i];
        }

    }


    boolean is_change_available(int v) {
        int m[][] = new int[n + 1][v + 1];
        int track[][] = new int[n + 1][v + 1];

        for (int i = 0; i <= v; i++)
            m[0][i] = 9999999;

        for (int i = 0; i < n; i++)
            m[i][0] = 0;


        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= v; j++) {

                m[i][j] = m[i - 1][j];
                track[i][j] = -1;
                //cout<<"going into loop l "<< currency[i-1]<< ": ";

                for (int l = 1; l <= count[i - 1]; l++) {

                    if (j - l * currency[i - 1] >= 0) {
                        if (m[i - 1][j - l * currency[i - 1]] + l < m[i - 1][j]) {
                            m[i][j] = m[i - 1][j - l * currency[i - 1]] + l;
                            track[i][j] = l;
                        }


                    } else
                        break;
                }
                //cout<<endl;

            }
        }

        for (int i = 0; i <= n; i++) {

            for (int j = 0; j <= v; j++) {

                // cout<<m[i][j]<<" ";
            }
            //cout<<endl;
        }
        //cout<< m[n][v]<<endl;
        int i = n;

        if (m[n][v] == 9999999) {


            return false;
        }

        return true;



    }

    boolean calculate_change(int v) {
        int m[][] = new int[n + 1][v + 1];
        int track[][] = new int[n + 1][v + 1];

        for (int i = 0; i <= v; i++)
            m[0][i] = 9999999;

        for (int i = 0; i < n; i++)
            m[i][0] = 0;


        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= v; j++) {

                m[i][j] = m[i - 1][j];
                track[i][j] = -1;
                //cout<<"going into loop l "<< currency[i-1]<< ": ";

                for (int l = 1; l <= count[i - 1]; l++) {

                    if (j - l * currency[i - 1] >= 0) {
                        if (m[i - 1][j - l * currency[i - 1]] + l < m[i - 1][j]) {
                            m[i][j] = m[i - 1][j - l * currency[i - 1]] + l;
                            track[i][j] = l;
                        }


                    } else
                        break;
                }
                //cout<<endl;

            }
        }

        for (int i = 0; i <= n; i++) {

            for (int j = 0; j <= v; j++) {

                // cout<<m[i][j]<<" ";
            }
            //cout<<endl;
        }
        //cout<< m[n][v]<<endl;
        int i = n;

        for (int j = v; j > 0; ) {

            if (track[i][j] == -1) {
                i--;
            } else {

                System.out.printf("currency %d * %d  = %d\n",currency[i-1],track[i][j],currency[i-1]*track[i][j]);
                count[i-1]-=track[i][j];

                j = j - track[i][j] * currency[i - 1];
            }


        }
        System.out.printf("total change  = %d",v);
        return true;

    }

}
