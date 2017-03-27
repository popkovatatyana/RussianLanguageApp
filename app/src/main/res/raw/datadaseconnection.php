<?php
    $con = mysqli_connect("localhost", "my_user", "my_password", "my_db");
    $name = S_POST["name"];
    $surname = S_POST["surname"];
    $username = S_POST["username"];
    $password = S_POST["password"];
    $age = S_POST["age"];

    $statement = mysqli_prepare($con, "INSERT INTO Users (name, surname, username, password, age") VALUES (?, ?, ?, ?, ?) ");
    mysqli_stmt_bind_param($statement, "siss", $name, $surname, $username, $password, $age);
    mysqli_stmt_execute($statement);
    mysqli_stmt_close($statement);
    mysql_close($con);
 ?>