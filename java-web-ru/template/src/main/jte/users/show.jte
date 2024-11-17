@import exercise.dto.users.UserPage;
@param UserPage page

<!doctype html>

<html lang="en">
    <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Page of user!</title>
    </head>
    <body>
		<h1>${page.getUser().getId()}</h1>
		<p>${page.getUser().getFirstName()}</p>
		<p>${page.getUser().getLastName()}</p>
		<p>${page.getUser().getId()}</p>
		<p>${page.getUser().getEmail()}</p>
    </body>
</html>