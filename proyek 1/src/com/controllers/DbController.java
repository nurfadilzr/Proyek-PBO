package com.controllers;

import com.config.MyConfig;
import com.models.Produk;
import java.sql.SQLException;

public class DbController extends MyConfig{

    public static void getDatabase() {
        connection();
        try {
            // query = "SELECT nama, harga, stok FROM tb_produk ORDER BY ID DESC";
            query = "SELECT NAMA, HARGA, JUMLAH FROM tb_barang";

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                System.out.println(
                    String.format("%s - Rp.%d - Stok %d", resultSet.getString("nama"), resultSet.getInt("harga"), resultSet.getInt("jumlah"))
                );
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Produk getProdukByNama(String nama) {
        Produk produk = null;
        connection();
        query = "SELECT * FROM tb_barang WHERE NAMA=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nama);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                produk = new Produk(resultSet.getInt("id"), resultSet.getString("nama"), resultSet.getLong("harga"), resultSet.getInt("jumlah"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produk;
    }

    public static boolean insertData(String nama, long harga, int jumlah) {
        connection();
        query = "INSERT INTO tb_barang (NAMA, HARGA, JUMLAH) VALUES (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.setLong(2, harga);
            preparedStatement.setInt(3, jumlah);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void updateNama(int id, String nama) {
        connection();
        query = "UPDATE tb_barang SET NAMA=? WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateHarga(int id, long harga) {
        connection();
        query = "UPDATE tb_barang SET HARGA=? WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, harga);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateJumlah(int id, int jumlah) {
        connection();
        query = "UPDATE tb_barang SET JUMLAH=? WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, jumlah);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean deleteData(String nama) {
        connection();
        query = "DELETE FROM tb_barang WHERE NAMA=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nama);
            int affectedRowDelete = preparedStatement.executeUpdate();
            if (affectedRowDelete > 0) {
                return true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }











    // // READ
    // public static void getDatabase(){
    //     MyConfig.connection();
    //     try {
    //         query = "SELECT NAMA, HARGA, JUMLAH FROM tb_produk";
    //         statement = connect.prepareStatement("UPDATE tb_barang SET JUMLAH=? WHERE ID=?");
    //         resultSet = statement.executeQuery("SELECT * FROM tb_barang");;

    //         while(resultSet.next()){
    //             System.out.println(
    //                 resultSet.getString("Nama") + ": Rp"+
    //                 resultSet.getString("Harga") + " (" +
    //                 resultSet.getString("Jumlah") + ")"
    //             );
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }   
    // }

    // // MENGEMBALIKAN PRODUK BERDASARKAN NAMA
    // public static Produk getProdukByNama(String nama) {
    //     Produk produk = null;
    //     MyConfig.connection();
        
    //     try {
    //         statement = connect.prepareStatement("UPDATE tb_barang SET JUMLAH=? WHERE ID=?");
    //         statement.setString(1, nama);
    //         resultSet = statement.executeQuery("SELECT * FROM tb_barang WHERE NAMA=?");
    //         while (resultSet.next()) {
    //             produk = new Produk(resultSet.getInt("ID"), resultSet.getString("NAMA"), resultSet.getLong("HARGA"), resultSet.getInt("JUMLAH"));
    //         }
    //         statement.close();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     return produk;
    // }

    // // INSERT atau MENAMBAHKAN DATA
    // public static boolean insertData(String nama, long harga, int jumlah) {
    //     String namaBaru;
    //     long hargaBaru;
    //     int jumlahBaru;

    //     Scanner sc = new Scanner(System.in);

    //     System.out.print("Nama : ");
    //     namaBaru = sc.nextLine();

    //     System.out.print("Harga : ");
    //     hargaBaru = sc.nextLong();

    //     System.out.print("Jumlah : ");
    //     jumlahBaru = sc.nextInt();

    //     MyConfig.connection();

    //     try {
    //         statement = connect.prepareStatement("UPDATE tb_barang SET JUMLAH=? WHERE ID=?");
    //         statement.executeQuery("INSERT INTO 'tb_barang' ('ID', 'Nama', 'Harga', 'Jumlah') VALUES (NULL, '"+namaBaru+"', '"+hargaBaru+"', '"+jumlahBaru+"')");
    //         System.out.println("Data berhasil disimpan");

    //         statement.close();
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //     }
    //     sc.close();
    //     return false;
    // }

    // // MENGEDIT NAMA PRODUK
    // public static void updateNama(int id, String nama) {
    //     MyConfig.connection();

    //     try {
    //         statement = connect.prepareStatement("UPDATE tb_barang SET JUMLAH=? WHERE ID=?");
    //         statement.setString(1, nama);
    //         statement.setInt(2, id);
    //         statement.executeUpdate("UPDATE tb_barang SET NAMA=? WHERE ID=?");
    //         statement.close();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    // }

    // // MENGEDIT HARGA PRODUK
    // public static void updateHarga(int id, long harga) {
    //     MyConfig.connection();

    //     try {
    //         statement = connect.prepareStatement("UPDATE tb_barang SET JUMLAH=? WHERE ID=?");
    //         statement.setLong(1, harga);
    //         statement.setInt(2, id);
    //         statement.executeUpdate("UPDATE tb_barang SET HARGA=? WHERE ID=?");
    //         statement.close();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    // }

    // // MENGEDIT JUMLAH PRODUK
    // public static void updateJumlah(int id, int jumlah) {
    //     MyConfig.connection();
        
    //     try {
    //         statement = connect.prepareStatement("UPDATE tb_barang SET JUMLAH=? WHERE ID=?");
    //         statement.setInt(1, jumlah);
    //         statement.setInt(2, id);
    //         statement.executeUpdate("UPDATE tb_barang SET JUMLAH=? WHERE ID=?");
    //         statement.close();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    // }

    // // MENGHAPUS DATA
    // public static boolean deleteData(String nama){
    //     MyConfig.connection();
    //     try {
    //         statement = connect.prepareStatement("UPDATE tb_barang SET JUMLAH=? WHERE ID=?");
    //         statement.executeUpdate("DELETE FROM tb_barang WHERE NAMA=?");
    //         statement.setString(1, nama);
    //         int affectedRowDelete = statement.executeUpdate("DELETE FROM tb_barang WHERE NAMA=?");
    //         if (affectedRowDelete > 0) {
    //             return true;
    //         }
    //         statement.close();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     return false;
    // }
}
