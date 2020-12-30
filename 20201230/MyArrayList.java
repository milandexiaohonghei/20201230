import java.util.Arrays;

public class MyArrayList {
    public static void main(String[] args) {
        int capacity = 5;
        MyArrayList1 myArrayList1 = new MyArrayList1(capacity);
        myArrayList1.add(0,1);
        myArrayList1.add(1,2);
        myArrayList1.add(2,3);
        myArrayList1.add(3,4);
        myArrayList1.display();
        myArrayList1.add(4,5);
        myArrayList1.display();
        myArrayList1.remove(2);
        myArrayList1.display();




    }



}



 class MyArrayList1<bollean> {

    /*public int[] elem = new int[10];
   public int usedSize = 0;
   */
    private int[] elem;//null
    private int usedSize;

    public MyArrayList1() {
        this.elem = new int[10];
    }

    public MyArrayList1(int capacity) {
        this.elem = new int[capacity];
    }


    // 判断是否为满
     public boolean isFull(){
         if(this.elem.length == this.usedSize ){
             return true;
         }
         return false;
     }

     //加长顺序表
     public void resize(){
        this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
     }

     // 打印顺序表
     public void display() {
         for (int i = 0; i <this.usedSize ; i++) {
             System.out.print(this.elem[i] + " ");
         }
         System.out.println();
     }
     // 在 pos 位置新增元素
     public void add(int pos, int data) {
        if(isFull()){
            System.out.println("你的顺序表已满");
            resize();
        }
        if(pos < 0|| pos > this.usedSize){
            System.out.println("pos的位置不合法");
            return;
        }
        for(int i = this.usedSize-1; i >= pos;i--){
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize ++;

     }

     //默认插入到数组的最后
     public void add2(int data){
        if(isFull()){
            resize();
        }
        this.elem[this.usedSize] = data;
        this.usedSize --;
     }
     // 判定是否包含某个元素
     public boolean contains(int toFind) {
         for(int i = 0;i < this.usedSize;i++){
             if(toFind ==this.elem[i]){
                 return true;
             }
         }
         return false;
     }
     // 查找某个元素对应的位置
     public int search(int toFind) {
         for(int i = 0;i < this.usedSize;i++){
             if(toFind ==this.elem[i]){
                 return i;
             }
         }
         return -1;
     }
     // 获取 pos 位置的元素
     public int getPos(int pos) {
         if(pos <0 || pos >= this.usedSize){
             return -1;
         }
         return this.elem[pos];
     }
     // 给 pos 位置的元素设为 value
     public void setPos(int pos, int value) {
         if(pos <0 || pos >= this.usedSize){
             return ;
         }
         this.elem[pos] = value;
     }
     //删除第一次出现的关键字key
     public void remove(int key) {
         int index = search(key);
         if(index == -1){
             System.out.println("没有");
             return;
         }
         for (int i = index; i < this.usedSize-1 ; i++) {
             this.elem[i] = this.elem[i+1];
         }
         this.usedSize --;
     }
     // 获取顺序表长度
     public int size() {
         return this.usedSize;

     }
     // 清空顺序表
     public void clear() {
        this.usedSize = 0;
     }

}
