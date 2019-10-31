To execute the client to download datasets, [download geneRFinderClient.jar](https://github.com/kriowloo/raissa/raw/master/geneRFinderClient.jar) and execute:

```sh
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
