we'll cover Hibernate advanced mappings.

So far in the course we've covered a very basic mapping,

we had a Student class

and then we mapped it to a student table.

And it worked fine just to kinda get us started

with Hibernate, but now let's go ahead

and move forward into some more advanced features.

So with advanced mappings,

in your database you most likely will have multiple tables

and you'll also have relationships between tables

and we need to somehow model this with Hibernate.

We'll look at three different types of advanced mappings,

we'll look at one-to-one, we'll also cover one-to-many,

and many-to-one, we'll take a look at many-to-many mappings.

All righty, so let's start with the one-to-one mapping.

So an instructor can have an instructor detail identity.

This is very similar to like, having an instructor profile.

So you have an instructor and then you also have

the actual instructor detail.

So the instructor has basic information

like their first name, last name and email,

the instructor detail has

just more profile-specific information

like their YouTube channel, their hobby,

their LinkedIn channel, their Twitter handle,

their Facebook page, so on and so forth,

just more details about a given instructor.

The key here is that this information is

in two separate tables.

Let's take a look at one-to-many mappings.

So, an instructor can have many courses,

so we have an instructor and then multiple courses out here

that are authored or created by that instructor,

so this is the classic one-to-many mapping.

Now, in this example we're gonna keep it simple,

such that a course only has one instructor.

I know there are scenarios where a course

can have multiple instructors,

but for right now we'll just keep it simple,

we'll cover another scenario for the many-to-many later.

So right now we'll just cover one-to-many.

Now, the actual opposite or inverse of this

is the many-to-one mapping.

So, here we have many courses

that can map to one instructor.

So it's really just an inverse

or the opposite of what we have here

with the one-to-many mapping.

And then here's the many-to-many mapping.

So, basically a course can have many students

and a student can have many courses.

So, here's our list of courses on the left-hand side

and a list of all the students on the right-hand side

and then you have this just wild (chuckles) mixture

of students assigned to different courses,

courses having students from all over.

So, this is a classic example here

of a many-to-many mapping.


--------------------------------------------------
Database Concepts
--------------------------------------------------


Alright, so now to take advantage of this,

we really have to cover some important database concepts.

So, we need to cover the idea of

primary keys and foreign keys,

and also the idea of cascading.

Now, you may already have experience with this; that's cool.

If not, don't worry.

I'll just do a level set for everyone,

just to make sure we're all on the same page.

So, a primary key is basically an identifier.

It identifies a unique row in a table,

and we've seen examples already

of making use of primary keys.

Now, the new item or the new player here is a foreign key.

This foreign key is basically what we use

to link tables together.

It's a field in one table that refers to the primary key

in another table.

So that's an important concept; foreign keys.

And I'll actually show you some examples of this one.

So, for foreign keys,

I have this one table called "instructor";

have my normal instructor information.

We also have a separate table,

"instructor detail",

that has all of our details for that given instructor.

Now, what we can do is make use of the

instructor detail column,

so this is basically a foreign key column

that we set up in our instructor table.

This basically has the link between the instructor

and the actual instructor detail.

So for myself, Darby,

my instructor detail ID is 100,

that links over to the primary key or the ID

in the instructor detail.

That's the idea of a foreign key;

links two tables together.

Now, another database concept that we need to cover here

is cascading.

You can cascade operations,

so cascade basically means

you can apply the same operation

to related entities, all right?

So here we have this instructor and instructor detail.

If I were to actually save the instructor,

then it'll also cascade that operation

and apply that same operation to instructor detail.

So I perform a save on instructor;

it does the same operation on instructor detail.

That's cascading.

Now, also, if we delete an instructor,

then we should probably also

delete their instructor detail, right?

So, if they no longer have an account,

well, why should we even keep their

detail information around?

So, this is known as a cascading delete.

So here, the instructor and the instructor detail,

if we go in a perform a delete on the instructor,

then we should also delete their instructor detail;

cascading delete.

And I'll show you a little example of this

here on this slide where I have the instructor, Darby.

We're gonna delete that instructor,

then it will also find that related entity,

the instructor detail,

and also delete that instructor detail entree

for that given instructor.

So that's an example of cascading delete.

But now, with cascading delete,

you have to be careful here,

because it really depends on the use case.

So, in this scenario,

with many to many,

with courses and students,

should we do a cascade delete here?

(laughs)

So, if we delete a student,

should we also delete the course?

No way!

(laughs)

You should remove the student from the course,

but you shouldn't delete the course, alright?

So, it really depends on your use case

and your application.

But the nice thing about it is that as a developer,

you have fine grain control over configuring cascading,

and I'll show you all of that in some of the later videos.

Also, when you retrieve data,

you have this idea of eager versus lazy loading.

So the question is, "If I retrieve the data,

"should we retrieve everything?"

So here I have an instructor

and an instructor also has courses.

So when I retrieve the instructor object,

should I get all of the courses for that instructor

immediately?

Or should I grab the courses only on request?

So Eager will retrieve everything in one shot.

Lazy will retrieve the data on request,

and I'll show you how to configure and set that up

when we make use of these advanced mappings.

Alrighty, here's an example of making use of

a uni-directional relationship.

So with uni-directional,

you have an instructor

and then you actually have the instructor detail.

So you start with the instructor object,

you load the instructor,

and then from there, you can access the instructor detail.

So it's really a one way relationship.

So that's uni-directional.

They also have the idea of bi-directional.

So here we have the instructor,

and then they have the relationship with

the instructor detail,

but then we can also go the other way,

so we can load the instructor detail

and have a reference to the given instructor.

So that's bi-directional.

And I'll show you how to do all the coding here

for uni-directional and also for bi-directional,