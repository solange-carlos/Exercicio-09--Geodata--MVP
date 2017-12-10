package br.usjt.desmob.geodata;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.lang.reflect.Field;

/*
 *  Criado por Solange Carlos em 10/12/2017.
 *
 */

public class Util {
    public static Drawable getDrawable(Context context, String nome){

        Class<?> c = R.drawable.class;
        try {
            Field idField = c.getDeclaredField(nome);
            int id = idField.getInt(idField);
            return context.getResources().getDrawable(id, null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
