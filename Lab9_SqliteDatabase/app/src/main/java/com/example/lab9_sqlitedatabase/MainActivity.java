package com.example.lab9_sqlitedatabase;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Database db;
    TodoAdapter todoAdapter;
    ListView todoListView;
    List<Todo> todoList;
    ImageView addImg;

    private void loadTodos() {
        todoList.clear();
        Cursor cursor = db.GetData("SELECT * FROM ToDoList ORDER BY todoId DESC");
        while (cursor.moveToNext()) {
            int todoId = cursor.getInt(0);
            String todoName = cursor.getString(1);
            todoList.add(new Todo(todoId, todoName));
        }
        cursor.close(); // Close the cursor to prevent memory leaks
        todoAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new Database(this, "GhiChu.sqlite", null, 1);

        db.QueryData("CREATE TABLE IF NOT EXISTS CongViec (id INTEGER PRIMARY KEY AUTOINCREMENT, TenCV NVARCHAR(200))");
//
//        // Inserting initial data for testing purposes
        db.QueryData("INSERT INTO CongViec VALUES(null, 'Project Android')");
        db.QueryData("INSERT INTO CongViec VALUES(null, 'Design app')");

//        db.QueryData("INSERT INTO ToDoList VALUES(null, 'Design App')");
//        db.QueryData("INSERT INTO ToDoList VALUES(null, 'Design Team')");

        Cursor dataCongViec = db.GetData("SELECT * FROM CongViec");
        while (dataCongViec.moveToNext()){
            String ten = dataCongViec.getString(1);
            Toast.makeText(this, ten, Toast.LENGTH_SHORT).show();
        }

        addImg = findViewById(R.id.addImg);
        todoList = new ArrayList<>();
        todoListView = findViewById(R.id.todoListView);
        todoAdapter = new TodoAdapter(this, R.layout.activity_todo, todoList);
        todoListView.setAdapter(todoAdapter);
        db = new Database(this, "ToDoList.sqlite", null, 1);
        db.QueryData("CREATE TABLE IF NOT EXISTS ToDoList (todoId INTEGER PRIMARY KEY AUTOINCREMENT, todoName NVARCHAR(200))");
        loadTodos();

        addImg.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Add Todo");
            EditText editText = new EditText(this);
            builder.setView(editText);
            builder.setPositiveButton("Add", (dialog, which) -> {
                String newTodoName = editText.getText().toString();
                if (newTodoName.trim().isEmpty()) {
                    Toast.makeText(this, "Todo name cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    db.QueryData("INSERT INTO ToDoList VALUES(null, '" + newTodoName + "')");
                    loadTodos();
                }
            });
            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());
            builder.show();
        });
    }

    public void dialogRemoveTodo(Todo todo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Remove Confirmation");
        builder.setMessage("Are you sure to remove " + todo.getTodoName() + "?");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            db.QueryData("DELETE FROM ToDoList WHERE todoId = " + todo.getTodoId());
            loadTodos();
            Toast.makeText(MainActivity.this, "Removed " + todo.getTodoName(), Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    public void dialogUpdateTodo(Todo todo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Update Todo");
        EditText editText = new EditText(this);
        editText.setText(todo.getTodoName());
        builder.setView(editText);
        builder.setPositiveButton("Update", (dialog, which) -> {
            String newTodoName = editText.getText().toString();
            if (newTodoName.trim().isEmpty()) {
                Toast.makeText(this, "Todo name cannot be empty", Toast.LENGTH_SHORT).show();
            } else {
                db.QueryData("UPDATE ToDoList SET todoName = '" + newTodoName + "' WHERE todoId = " + todo.getTodoId());
                Toast.makeText(this, "Updated " + todo.getTodoName() + " to " + newTodoName, Toast.LENGTH_SHORT).show();
                loadTodos();
            }
        });
        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());
        builder.show();
    }
}
