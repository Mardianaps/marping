package comww.example.android.utsmardiana;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper  extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "userTokopedia.db";
    private static final String TABLE_USER = "userpedia";


    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";
    private static final String COLUMN_USER_NAMA = "user_nama";


    private String CREATE_USER_TABLE = " CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_EMAIL + " TEXT, " + COLUMN_USER_PASSWORD + " TEXT,"
            + COLUMN_USER_NAMA + " TEXT" + ")";

    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_USER_TABLE);
        onCreate(db);
    }

    public void addUser(ModelUser user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        values.put(COLUMN_USER_NAMA, user.getNama());

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public boolean checkUser(String email){
        String[] columns = {COLUMN_USER_ID};
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_USER_EMAIL + " = ? ";
        String[] selectionArgs = {email};
        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if(cursorCount > 0){
            return true;
        }
        return false;
    }

    public boolean checkUser(String email, String password){
//        String[] columns = {COLUMN_USER_ID};
//        SQLiteDatabase db = this.getReadableDatabase();
//        String selection = COLUMN_USER_EMAIL + " = ? " + " AND " + COLUMN_USER_PASSWORD + " = ?";
//        String[] selectionArgs = {email, password};
//        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);
//        int cursorCount = cursor.getCount();
//        cursor.close();
//        db.close();

        SQLiteDatabase dbb = this.getReadableDatabase();
        Cursor cu = dbb.rawQuery("select * from "+TABLE_USER+" Where "+COLUMN_USER_EMAIL+"=? and "+COLUMN_USER_PASSWORD+"=? ",new String[]{email,password} );

        if(cu.getCount() > 0){
            return true;
        }
        return false;
    }

}
