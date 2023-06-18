# App.java
didalamnya terdapat main method untuk menjalankan program

Menu.showMenu();
method ini digunakan untuk memilih menu pengolah data yang diinginkan

# com
didalamnya ada beberapa package, yaitu:
1. config
2. controllers
3. layout
4. models

## config
terdapat 1 file dengan nama MyConfig.java berisi abstract class yang memiliki beberapa variabel, objek, dan method connection() untuk mengoneksikan data yang diinput dengan database.

## controllers
terdapat 1 file yaitu DbController.java yang mengextends class MyConfig. class ini berisi beberapa method yang berguna untuk mengolah data, seperti menampilkan, menambah, mengedit, dan menghapus data

## layout
terdapat 1 file yaitu Menu.java yang berisi method showMenu() dan selectMenu() untuk menampilkan dan memilih menu pengelola data yang diinginkan.
terdapat 4 file yang masing-masing berisi method static yang akan menampilkan menu-menu pengolah data

## models
terdapat 1 file yaitu Produk.java yang berisi variabel, constructor, dan method setter getter untuk menyimpan data produk
