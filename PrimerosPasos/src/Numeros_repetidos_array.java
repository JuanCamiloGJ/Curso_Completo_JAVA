public class Numeros_repetidos_array {
    public static void main(String[] args) {
        

       Numeros_repetidos_array obj=new Numeros_repetidos_array();
       obj.arranque();


    }
       
    
        int array[]={1, 2, 4, 5, 4, 3, 3, 1, 5, 3, 5, 5, 5, 6, 6, 6,};
        int duplicados[];
        int numrepetido=0, varduplic=0;
        public void arranque(){
            //asigana mismo tamaño de array principal
            duplicados =new int[array.length];
            comparac();

            for (int i : duplicados) {
                System.out.println(i);
            }
            mostrararray();
        }
   
        public void mostrararray() {
            //hay una array con muchos 0, y con un valor que se repite
            System.out.println("Los numeros que se repiten son: ");
          //asi que se valida para mostrarlos, si son mayores a 1, se debe imprimir
            for (int i : duplicados) {
               if(i>=1){
                   System.out.print(i+" ");
               }
           }
        }

        public void comparac(){
            //variable boolean para saber si se repite el numero
            boolean serepite=false;
            //doble for para recorrer array principal
            for(int i=0;i<array.length;i++){
                for(int j=i+1; j<array.length; j++){
                    //se mantiene en falso por cada ciclo, hasta que se compruebe
                    serepite=false;
                    //si el numero coincide con otra posicion en el array
                    if (array[i]==array[j]) {
                        //se verifica en el segundo array si ya se almaceno ese numero
                        for(int k=0; k<duplicados.length;k++){
                            //se compara cad auna de las posiciones del segundo array
                            //si se comprueba que ya existe el numero la variable boolean pasa a ser verdadera
                            if(duplicados[k]==array[j]){
                                serepite=true;
                            }
                        }
                        //al terminar el ciclo for , se compara la variable, si esta estaba repetida en el segundo array
                        //de no ser así, se almacena en la posición donde se encuentra
                        if (serepite==false) {
                            //System.out.println(array[j]);
                            duplicados[i]=array[j];
                            
                        }
                        
                    }
                    
                }
            }

        }

}
