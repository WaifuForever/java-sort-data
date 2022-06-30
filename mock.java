interface Sort {
   shufflePiorCaso();

   shuffleMelhorCaso();

   sort();
}
/*
 * private void partOne (int[] arr, Sort sort){
 * 
 * BufferReader bf = "path/to/file"
 * 
 * 
 * 
 * const file = openFile("password_classifier.csv", "w");
 * const file2 = openFile("password_classifier2.csv", "w");
 * const file3 = openFile("password_fomartedData.csv", "w");
 * 
 * 
 * 
 * }
 */

/*
 * class MergeSort implements Sort {
 * shufflePiorCaso()
 * 
 * shuffleMelhorCaso()
 * 
 * sort()
 * }
 */

class MergeSort extends Resultados {
   String lastEmbaralhamento = null;

   sufferPiorCaso(){
		this.lastEmbaralhamento="PiorCaso";
	}

   sort(){
		super().begin_relatario();// salvar tempo atual
		//ornenação com mergsort
		super().generate_relatorio(this.lastEmbaralhamento);// nome algoritimo,caso, tempo total
		//acrescer na ultima linha do csv o resultado.
	}
}

private class InsertionSort extends Resultados {
      String lastEmbaralhamento = null;

      sufferPiorCaso(){
		this.lastEmbaralhamento="PiorCaso";
	}
}
