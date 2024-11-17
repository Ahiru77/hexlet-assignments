

@import exercise.dto.users.UsersPage;
@param UsersPage page

<!doctype html>

<html lang="en">
    <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Page of user!</title>
    </head>
    <body>
		@for(var user : page.getUsers())
               <div>
                   <h2><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></h2>
               </div>
            @endfor
	<p> <form action="/courses" method="get">
	<input type="search" name="term" value="${page.getTerm()}" />
	<input type="submit" value="Search" />
	</form>
	</p>
    </body>
</html>