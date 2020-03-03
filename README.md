# Usage

To execute the client in order to download datasets, [download geneRFinderClient.jar](https://github.com/kriowloo/raissa/raw/master/geneRFinderClient.jar), check if you have Java JRE version 1.5 (or higher) installed and then execute:

```sh
  $ java -jar geneRFinderClient.jar <dataset_name> <resource_name>
```
> Note: If you don't have Java installed, you can use *openjdk Docker image*, as described below (after executing, type *exit* and the downloaded files will be saved into the specified folder):

```sh
  $ docker run -it -v /folder/where/client/was/saved:/data openjdk:8
  $ cd /data
  $ java -jar geneRFinderClient.jar <dataset_name> <resource_name>
```


Example: to download all the files from dataset *training1*, run:

```sh
  $ java -jar geneRFinderClient.jar training1 all
```
This execution will download files *orfs.fasta*, *genomes.csv*, and *groundtruth.csv* from dataset *training1* and save it into the current folder.

To see complete usage, run:

```sh
  $ java -jar geneRFinderClient.jar
```
