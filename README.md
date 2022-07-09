# java-sort-data (Projeto Passwords)

Please read our Guidelines to see what this project is about:
- [English](GUIDELINES.md)
- [Português](GUIDELINES.pt-BR.md)
## Article and Data Analysis
- [Article](https://github.com/WaifuForever/java-sort-data/blob/slave/LEDA_Password_Project.pdf)
- [Grafic-1](https://github.com/WaifuForever/java-sort-data/blob/slave/synlog.png)
- [Grafic-2](https://github.com/WaifuForever/java-sort-data/blob/slave/logn.png)
## How to Run
   When we actually have some code here, we're going to explain how to run it.
### Requirements
- java 8+
- javac with equivalent version of java

### Compile
```bash
javac src/App.java
```

### Execution
```bash
java src.App
```
## Roadmap
   We're going to set goals here, basically we are going to describe all features of the application and say if they're complete or not.

   - Implement algorithms // (needs QuickSort3, HeapSort) // Fer
   - classify Password // Jojo
   - generate csv // JP
   - open file // JP

   - part One // JP, Jojo
   - part Two // Jojo, JP, Fer



   - Read Csv
   - Interate Csv
   - Classify passwords. Generate *password_classified.csv*

   - Transformations 
      Generate *passwords_formated_data.csv*
      Filter *password_classified2.csv* (Good, very Good)

   - Ordenate
      1- Sort *passwords_formated_data.csv* by length **decreasing**
         - Apply sort algorithm (Best, Worse, medium)
         - Generate Csv for (Best, Worse, medium)
      
      2- Sort *passwords_formated_data.csv* by month **increasing**
         - Apply sort algorithm (Best, Worse, medium)         
         - Generate Csv for (Best, Worse, medium)  

      3- Sort *passwords_formated_data.csv* by date **increasing**
         - Apply sort algorithm (Best, Worse, medium)         
         - Generate Csv for (Best, Worse, medium)   
   


## Contributing
   All code must be written in english and all commits must follow the standard established in [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/)

   Do not push into the `main` branch, use secundary branchs instead. Last but not least, always run tests before commiting changes.


