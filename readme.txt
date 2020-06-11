-----------------------------------------
MANY-TO-MANY
-----------------------------------------

we'll cover Hibernate many-to-many.

And we'll have the scenario where

a course can have many students,

and a student can be signed up for many courses.

So in the bottom left we have our courses

and in the bottom right we have our students,

and then way have this many-to-many relationship

between courses and students.

Now, we somehow need to keep track of relationships.

We need to keep track of which student is in which course

and vice-versa.

And what we can do is actually make use of a join table.

So this join table's a special table

that'll maintain the relationships between

a course and students.

So you can use this join table to find out

who signed up for which course.

So here's a formal definition of a join table.

It's basically a table that provides

a mapping between two tables.

It has foreign keys for each table,

and it's used to define the mapping relationship.

And we'll see a lot of examples here using join tables

in this video series.

So here's our diagram.

So we have our courses up top,

we have our students in the bottom-right,

and then in the bottom left we have this join table.

So this join table's called course_student.

This join table maintains the relationship between courses

and students.

All right, so let's go ahead and look at

a join table example.

In this example, I wanna find John's courses.

So here's our database diagram.

Recall in the bottom left is our join table, course_student.

This will kind of maintain a relationship

between courses and students.

And then let's overlay some data.

So up top we have data for courses,

so we have three courses, Pacman, Rubik's Cube, and Atari.

And then in the bottom right we have some sample data

here for students.

So we have two students, John Doe and Mary Public.

And then overlaying some data here for our join table

and course-student, we have data and some entries here.

And we'll kind of walk through how these numbers match-up

and how they work out.

So now, if I wanna find John's courses

then I go and look in the student table for John,

and I get John's student ID.

So I see that John has student ID of 1.

That takes me over to the join table

and in the join table we have an entry.

So, hey, here's a list of courses where student ID equals 1.

That maps to course ID 10,

which in turn points back to the course table.

Now we see that John is in the Pacman course.

So that's how we use the join table to kind of

find courses for a given student.

Now, Let's do another example here,

and let's find Mary's courses.

So again, in the student table we see that Mary

has a student ID of 2.

That maps over to the join table,

and oh wow, look, there's three entries here

for student ID equals 2.

So those are three courses.

Now let's go ahead and look up those course IDs

in the course table.

And yeah, we see three courses, Pacman,

Rubik's Cube, and Atari 2600.

So we know that Mary's assigned to three courses here.

So, again, a good example of using our join table

to find courses for a given student.

All right, so this is good stuff.

We'll build all of this step-by-step.

So in the first step we'll do our prep work,

we'll define our database tables.

Then we'll update our course class,

we'll update our student class,

and then we'll pull it all together

by creating a main application.

Alrighty, so let's go ahead and look at

our database table for the join table: course_student.

So here's the sequel.

So we'll basically create this join table,

it's gonna have two columns, course_id and student_id,

and we'll also set those columns up to be the primary key.

So the primary key will be composed of two columns,

course_id and student_id.

Now we need to set up the foreign keys.

This will basically tell the join table

how to point back to the appropriate table, all right?

So here's our sequel up top.

We'll set up this foreign key constraint for course_id,

and it's gonna reference the course table, the id column.

So that'll be a link between this join table, course id,

and the actual course table.

And now we'll do a similar thing for student.

So we'll set up this constraint foreign key student.

Student ID.

And then we'll go ahead and say

it's gonna reference the student table, the ID column.

And then that'll give us this link here on the bottom,

so our core student join table, our student ID,

links back to or points to the student table ID column.

So that's how our whole foreign key relationship works






Now, moving to step two,

we're gonna update our course to reference students.

So, basically our course

is gonna have a list of students.

And then we'll also define the appropriate

getter setter methods for this field.

Now, the important thing here is adding

the many to many annotation.

So we're gonna annotate this field with @manytomany.

And then we'll at this join table annotation.

So the join table basically tells Hibernate

which join table that you'll use,

so name equals course student.

And then we'll also specify the join columns.

So here I have join column, name equals course I.D.

This basically tells Hibernate,

"Hey, refer to the course I.D. column

in the course student join table."

And then we'll do a similar thing here for a student.

For the inverse column, we'll say

join column, name equals student, underscore I.D.

So again, look into this join table

and look for the column student underscore I.D.,

to find the appropriate students for this course.

Now, a bit more on this @jointable.

So at the bottom, we have the code and the diagram.

The @jointable tells Hibernate,

"Hey, look at the course I.D. column

in the course student table,

and for the other side, or the inverse,

look at the student I.D. column

in the course student table."

And then Hibernate will use this information

to find a relationships between the course and students.

So, here we have join column course I.D.,

points to a course student, over to the actual course.

And then a similar thing here for the student I.D.

So, it points to student I.D. in the join table,

which then points back to the student table.

And this is all based on the foreign keys

that we set up in some of the previous slides.

Okay, so let's dig a little bit deeper, here.

So, more on the inverse.

In this context, we're defining a relationship

in the course class, so we are here.

We're on the course side of the house.

The student class is on the other side,

so it's considered the inverse.

Inverse refers to the other side of the relationship.

We're defining code and course,

the inverse is the actual student reference.

So that's the other side.

All right, now let's go ahead

and do a similar thing for student.

We'll simply just go the other way.

This is step three of updating

the student to reference courses.

So a student class has a list of courses.

And then we'll also, again,

do the getters and setters for this.

But again, the important thing here

is adding the @manytomany annotation.

So we're in the class student,

we have @manytomany, and then we'll also

set up a reference for join table.

Again, join table will give the actual

name of the join table course underscore student.

And then the join columns and the inverse join columns.

Here join columns student I.D.,

refers to the student I.D. in the course student table.

Because right now we're in the student class.

Now, the inverse is the course I.D.

in the course student table.

That's the other side.

So note here, we're writing code in student right now.

The inverse is the other side,

that's the course, so we are reference course I.D.

So the @jointable tells Hibernate,

"Hey, look at the student I.D.

in the course student table."

And then for the other side of the inverse,

look at the course I.D. in the course student table.

And again, use this information to build

a relationship between students and courses.

So at the bottom, we have student,

according to student I.D.

And then we also have this course I.D.,

pointing to the actual course table.

So that kind of pulls together

the whole relationship between this.

So again, we're writing code right now in student,

and we're pointing to an actual course, or list of courses.

So just a bit more on this inverse, again.

We're defining the relationship in the student class,

so we're here over on the right hand side.

The other side is course,

so that's considered the inverse.

That's why we reference

it as the inverse side of the inverse column.

Inverse refers to the other side.

So basically, whatever you're pointing to,

whatever collection that you're referring to,

that's the inverse.

And we'll see a lot of coding examples

coming up with that, also.

All righty, so we're at step four, the grand finale.

Creating the main application.

So in our main method here,

basically we'll just get the course object.

We'll set up the course I.D.,

and then we'll say session dot get, on that given I.D.

Once we have the course,

then we can go ahead and print out the course

by using a little system out print line.

And then also, this course has a list of students.

So I can go ahead and do a print line

on temp course dot get students.

And that kind of handles that many to many out relationship.

Now, I always like to pull this into a real world project.

This project requirement here is that

if we delete a course, do not delete the students.

Basically do not apply cascading deletes.

And the same holds true for the other side.

If you delete a student, don't delete the course.

And in the next set of videos,

we're gonna add support for some other features.

We'll add support for lazy loading of students and courses.

And then we'll also add support

for cascading to handle saves, but not deletes.

So again, if we delete a course, don't delete the students.

And likewise, if we delete a student,

don't delete the course.

All right, so a lot of good stuff here.

A lot of good theory.

We laid the ground work.

In the next set of videos, we'll move into our coding,

we'll write code, we'll get this many to many working.

We'll use join tables and ...

(sighs)

We'll pull it all together.

(laughs)

So don't you worry, you'll have many to many

working and running on your computer

by the end of this series.