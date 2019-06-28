package ZExercise;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateBasedDirectory {
	
	public static String createDateBasedDirectory(String baseDirectory, Date argDate) {
        String newDir = null;

        if (baseDirectory != null && argDate != null) {
            try {
                String format = "yyyy-MM-dd";
                DateFormat dateFormatter = new SimpleDateFormat(format);
                String date = dateFormatter.format(argDate);
                File f = new File(baseDirectory);
                File files[] = f.listFiles();
                String dir = null;
                
                int baseDirLength = baseDirectory.length();
                int checkingLength = baseDirLength + format.length() + 3;

                int maxSeqNo = 0;

                for (int i = 0; i < files.length; i++) {
                    if (files[i].isDirectory()) {
                        dir = files[i].toString();
                        if (dir.length() == checkingLength) {
                            String existingDirDate = dir.substring(baseDirLength, baseDirLength + 10);

                            if (date.equalsIgnoreCase(existingDirDate)) {
                                int dirSeqNo = 
                                    Integer.parseInt(dir.substring(baseDirLength + 11, baseDirLength + 10 + 3));

                                if (dirSeqNo > maxSeqNo) {
                                    maxSeqNo = dirSeqNo;
                                }
                            }
                        }
                    }
                }

                String currSeq = "" + (maxSeqNo + 1);
                if (currSeq.length() == 1) {
                    currSeq = "0" + currSeq;
                }

                newDir = baseDirectory + date + "-" + currSeq;
                new File(newDir).mkdir();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return newDir;
    }
}
