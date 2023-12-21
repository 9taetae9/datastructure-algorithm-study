//배열로 해시테이블 구현

class MyHashTable{
    Integer[] table;
    int elemCnt;
    MyHashTable(){}
    MyHashTable(int size){
        this.table = new Integer[size];
        this.elemCnt = 0;
    }
}
//public class Practice2_Hashtable {
//    //Test code
//    MyHashTable ht = new MyHashTable(7);
//    ht.setValue(1,1);
//    ht.setValue(2,2);
//    ht.setValue(3,3);
//    ht.setValue(4,4);
//    ht.setValue(5,5);
//    ht.printHashTable();
//    ht.setValue(8,6);
//    ht.printHashTable();
//}
