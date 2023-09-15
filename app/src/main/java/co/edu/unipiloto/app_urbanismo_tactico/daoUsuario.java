package co.edu.unipiloto.app_urbanismo_tactico;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import java.util.ArrayList;

    public class daoUsuario {
    Context c;
    Usuario u;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String bd ="BDUsuariosUT";
    String tabla="create table if not exists RegistroUsuarios (id integer primary key autoincrement, nombre text,usuario text, cedula text, email text, pass text, confirmpass text )";


        public daoUsuario (Context c) {
            this.c = c;
            sql = c.openOrCreateDatabase (bd, c.MODE_PRIVATE,  null);
            sql.execSQL(tabla);
            u=new Usuario ();
        }

public boolean insertUsuario (Usuario u) {
    if (buscar(u.getUsuario())==0){
        ContentValues cv=new ContentValues ();
        cv.put ("nombre",u.getNombre());
        cv.put ("usuario",u.getUsuario());
        cv.put ("cedula",u.getCedula());
        cv.put ("email",u.getEmail());
        cv.put ("pass",u.getPassword());
        cv.put("confirmpass",u.getConfirmpassword());
        return (sql.insert("RegistroUsuarios", null,cv)>0);
    }else {
        return false;
    }

}

    public int buscar (String u) {
        int x=0;
        lista= selectUsuario();
        for (Usuario us:lista) {
            if (us.getUsuario().equals(u)){
                x++;
            }
        }
        return x;
    }

        public ArrayList<Usuario> selectUsuario(){
            ArrayList<Usuario> lista=new ArrayList<Usuario>();
            lista.clear();
            Cursor cr=sql.rawQuery ( "select * from RegistroUsuarios", null);
            if(cr!=null&&cr.moveToFirst()){
                do {
                    Usuario u=new Usuario();
                    u.setId(cr.getInt(0));
                    u.setNombre(cr.getString(1));
                    u.setUsuario(cr.getString(2));
                    u.setCedula(cr.getString(3));
                    u.setEmail(cr.getString(4));
                    u.setPassword(cr.getString(5));
                    u.setConfirmpassword(cr.getString(6));
                    lista.add(u);

                }while(cr.moveToNext());
            }
            return lista;
        }

        public int login(String u, String p){
            int a=0;
            Cursor cr=sql.rawQuery ( "select * from RegistroUsuarios", null);
            if(cr!=null&&cr.moveToFirst()){
                do {
                   if (cr.getString(2).equals(u)&&cr.getString(5).equals(p)){
                       a++;
                   }

                }while(cr.moveToNext());
            }
            return a;
        }

        public  Usuario getUsuario(String u, String p){
            lista = selectUsuario();
            for (Usuario us:lista) {
                if(us.getUsuario().equals(u)&&us.getPassword().equals(p)){
                    return us;
                }
            }
            return null;
        }

        public  Usuario getUsuarioById(int id){
            lista = selectUsuario();
            for (Usuario us:lista) {
                if(us.getId()==id){
                    return us;
                }
            }
            return null;
        }
    }





