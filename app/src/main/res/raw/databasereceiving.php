<?php
    $con = mysqli_connect("localhost", "my_user", "my_password", "my_db");
    $username = S_POST["username"];
    $password = S_POST["password"];

    $statement = mysqli_prepare($con, "SELECT * FROM Users WHERE username = ? AND password = ?");
    mysqli_stmt_bind_param($statement, "ss", $username, $password);
    mysqli_stmt_execute($statement);

    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $name, $surname, $username, $password, $age);
    $user = array();
    while(mysqli_stmt_fetch($Statement)){
    $user[name] = $name;
    $user[surname] = $surname;
    $user[username] = $username;
    $user[password] = $password;
    $user[age] = $age;
    }

    echo json_encode($user);
    mysqli_stmt_close($statement);
    mysql_close($con);
?>