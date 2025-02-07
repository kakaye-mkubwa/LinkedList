public class LQHashed_Bhattarai {

    int N;
    int n = 0;
    int defaultQuotient = 9967;
    double loadingFactor = 0.75;
    Student_Bhattarai deleted;
    private Student_Bhattarai[] data;

    public LQHashed_Bhattarai(int length) {

        int pct = (int) ((1.0 / loadingFactor-1)*100.0);
        N = fourKPlus3(length,pct);
        data = new Student_Bhattarai[N];
        deleted = new Student_Bhattarai("","",null);
        for (int i = 0; i < N; i++) {
            data[i] = null;
        }
    }

    public boolean insert(Student_Bhattarai newStudent){
        boolean noError;
        boolean hit = false;
        int pass,q,offset,ip;
        int pk = stringToInt(newStudent.getStudentID());
        if ((((double)n)/N)< loadingFactor){
            pass = 0;
            q = pk/N;
            offset = q;
            ip = pk %N;
            if (q%N == 0){
                offset = defaultQuotient;
            }
            while (pass < N){
                if (data[ip] == null || data[ip] == deleted){
                    hit=true;
                    break;
                }
                ip = (ip + offset)%N;
                pass = pass+1;
            }
            if (hit==true){
                data[ip]=newStudent.deepCopy();
                n++;
                return noError = true;
            }else{
                return noError = false;
            }
        }else{
            return noError = false;
        }
    }

    public Student_Bhattarai fetch(String targetKey){
        boolean noError;
        boolean hit = false;
        int pass,q,offset,ip;
        int pk = stringToInt(targetKey);
        pass = 0;
        q = pk/ N;
        offset = q;
        ip = pk % N;
        if (q % N == 0){
            offset = defaultQuotient;
        }
        while (pass<N){
            if (data[ip] == null){
                break;
            }
            if (data[ip].compareTo(targetKey) == 0){
                hit = true;
                break;
            }
            ip = (ip + offset) % N;
            pass = pass + 1;
        }

        if (hit == true){
            return data[ip].deepCopy();
        }else{
            return null;
        }
    }

    public boolean delete(String targetKey){
        boolean noError;
        boolean hit = false;
        int pass,q,offset,ip;
        int pk = stringToInt(targetKey);
        pass = 0;
        q = pk/N;
        offset = q;
        ip = pk % N;
        if (q % N == 0){
            offset = defaultQuotient;
        }
        while (pass < N){
            if (data[ip] == null){
                break;
            }
            if (data[ip].compareTo(targetKey) == 0){
                hit = true;
                break;
            }
            ip = (ip+offset) % N;
            pass = pass + 1;
        }
        if(hit == true){
            data[ip] = deleted;
            n--;
            return noError = true;
        }else{
            return noError = false;
        }
    }

    public boolean update(String targetKey, Student_Bhattarai newStudent){
        if (delete(targetKey) == false){
            return false;
        }else if(insert(newStudent) == false){
            return false;
        }else{
            return true;
        }
    }

    public void showAll(){
        for (int i = 0; i < N; i++) {
            if (data[i] != null && data[i] != deleted){
                System.out.println(data[i].toString());
            }
        }
    }

    public void writeToFile(){
        for (int i = 0; i < N; i++) {
            if (data[i] != null && data[i] != deleted){
                data[i].toFile();
            }
        }
    }

    public static int fourKPlus3(int n,int pct){
        boolean fkp3 = false;
        boolean aPrime = false;
        int prime,highDivisor,d;
        double pctd = pct;
        prime = (int) (n * (1.0 + pctd / 100.0));

        if (prime %2 == 0){
            prime = prime + 1;
        }
        while(fkp3 ==false){
            while(aPrime == false){
                highDivisor = (int) (Math.sqrt(prime) + 0.5);
                for (d = highDivisor; d > 1; d--) {
                    if (prime % d == 0){
                        break;
                    }
                }
                if (d != 1){
                    prime = prime + 2;
                }else {
                    aPrime = true;
                }
            }
            if ((prime - 3) % 4 == 0){
                fkp3 = true;
            }else{
                prime = prime + 2;
                aPrime = false;
            }
        }
        return prime;
    }

    public static int stringToInt(String aKey){
        int pseudoKey = 0;
        int n = 1;
        int cn = 0;
        char c[] = aKey.toCharArray();
        int grouping = 0;

        while(cn < aKey.length()){
            grouping = grouping << 8;
            grouping = grouping + c[cn];
            cn = cn + 1;
            if (n ==4 || cn == aKey.length()){
                pseudoKey = pseudoKey + grouping;
                n = 0;
                grouping = 0;
            }
            n = n+1;
        }
        return Math.abs(pseudoKey);
    }
}
