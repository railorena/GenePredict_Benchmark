package generfinder;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;

public class BenchmarkClient{
    public static final String baseHost = "https://github.com/kriowloo/raissa/raw/master/";
    private static String[] datasetNames = {"training1", "validation", "training2", "test1", "test2low", "test2medium", "test2high1", "test2high2", "test2high3"};
    private static String[] resources = {"orfs", "groundtruth", "genomes"};
    private static String[] filenames = {"orfs.fasta", "groundtruth.csv", "genomes.csv"};

    private static String[] checkResource(String datasetName, String resource){
        boolean datasetFound = false;
        for (String ds : datasetNames){
            if (ds.equals(datasetName)){
                datasetFound = true;
                break;
            }
        }
        if (!datasetFound){
            return null;
        }
        if ("all".equals(resource)){
            return filenames;
        }
        for (int i = 0; i < resources.length; i++){
            String rs = resources[i];
            if (rs.equals(resource)){
                return new String[]{filenames[i]};
            }
        }
        return null;
    }

    public static void download(String datasetName, String resource){
        String[] fileNames = checkResource(datasetName, resource);
        if (fileNames == null){
            System.out.println("Resource and/or dataset not found. Please, check then and try again.");
            return;
        }
        for (String fileName : fileNames){
            try{
                String url = baseHost + datasetName + "/" + fileName;
                BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
                FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                byte dataBuffer[] = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }
                fileOutputStream.close();
                in.close();
                System.out.println("File " + fileName + " downloaded successfully!");
            }catch(Exception e){
                System.out.println("Error to download resource. Please, check your internet connection and try again.");
            }
        }
    }

    private static String getDatasetNamesAsString(){
      String text = "";
      for (String ds : datasetNames){
          if (text.length() == 0){
              text += ds;
          }else{
              text += ", " + ds;
          }
      }
      return text;
    }

    private static String getResourcesAsString(){
      String text = "";
      for (String rs : resources){
          if (text.length() == 0){
              text += rs;
          }else{
              text += ", " + rs;
          }
      }
      return text;
    }

    public static void main(String[] args){
        if (args == null || args.length != 2){
            System.out.println("Please, inform dataset name and resource desired.");
            System.out.println("");
            System.out.println("Usage:   java -jar geneRFinderClient.jar <dataset_name> <resource_name>");
            System.out.println("             dataset_name: " + getDatasetNamesAsString());
            System.out.println("             resource_name: " + getResourcesAsString() + " (or 'all' to download all resources)");
            System.out.println("");
            System.out.println("Example: java -jar geneRFinderClient.jar training1 orfs");
            return;
        }
        download(args[0], args[1]);
    }
}
