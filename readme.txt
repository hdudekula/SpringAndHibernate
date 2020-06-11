-----------------------------------------
EAGER Vs Lazy Loading
-----------------------------------------

In this video, we're gonna cover fetch types for

eager versus lazy.

Now, when we load data, or we retrieve or fetch

data, the question is should we retrieve everything?

So, an eager load will pull in everything.

Lazy load will retrieve data only on request.

So, imagine we have an instructor. An instructor

has a list of courses. Depending on the loading

type, that will determine when and how the data is

loaded from the data base by Hibernate.

And, it'll also has an implication on your actual

performance of your given app.

Now, with eager loading, it will actually load

all your dependent entities.

So, it'll load the instructor and and all of their

courses at once.

So, it will do a one, quick shot to the database,

grab all the data and bring it back.

Now, this may not be a big deal if you only have

a small number instructor and a small number of

courses, but you can imagine if you had a lot

of data out there, that could actually impact the

performance of your application.

Now, let's take a look at another

example with eager loading.

So, what about a course and students?

So, this could easily turn into a performance nightmare.

So, if we were to load a course and then actually load

all of the students for the course, then this could

possibly slow down our application or not even possibly

most likely, it will slow down our application.

Because, just like the course you are attending now,

a given course could have 10,000, 20,000, maybe 50,000

students and we really don't need all that data

at this point.

So, in our app, if we're simply searching for a

course by keyword, like just doing your normal

search there, we only want a list of matching courses.

But eager loading, it will still load all the students

for each course and that's not good, right?

We only want the titles or the descriptions of the

courses but not all of the students.

So, the best practice ... ding, ding, ding!

The best practice in the industry is to only

load data when absolutely needed.

So, you should prefer lazy loading instead of

eager loading. Now, there's always exceptions to

the rule, right?

And there's also special use cases, but in general,

the recommendation is to prefer lazy loading over

eager loading.

Alrighty, so with lazy loading.

So, lazy loading will load the main entity first,

and then it will actually load the dependent

entities on demand, at a later time.

So, here we have a course, so it will actually

load the course first and then, when you need

a list of students, then that's when it will

actually go to the database and load those

students on demand.

So, they will be loaded at a later time.

And, again, remember, the preference here is

on making use of lazy loading to make sure

our application performs in a fast manner.

So, lazy loading is preferred.



Okay, so let's go ahead and pull this

together with the real-world use case.

And that's for searching for instructors.

So I have this website here luv2code academy,

it will give me a list of instructors.

I can also type in the instructors name

and search for them.

So in this case, I simply want to get a high level

list of the instructors.

And then over on the far right,

there's an action link where you can actually go ahead

and drill down and view the details of a given instructor.

So in our Real-World use case,

in the Master view, we want to make use of lazy loading.

In the Detail view, we want to retrieve the entity

and their necessary dependent entities.

So a bit more on the Master view here.

So in this case, I'm gonna use

lazy loading for the search results.

So basically, I only wanna load the instructors

but not their courses.

So again, I simply want a high level view

of the instructors but I'm not

really concerned about their courses at the moment.

If we wanted course information,

we can select the link here, view details,

to actually drill down into that given instructor.

So this will actually result in a faster,

query on our database application.

Okay so looking at the Detail view,

here we'll actually retrieve the entity

and their necessary dependent entities.

So here we'll actually load the instructor

and their courses.

So I have the instructor, John Doe.

His email address and then I also have

the list of courses for this given instructor.

So this works out fine right, because we're only looking

at one instructor, and only their list of courses.

We're not trying to access a thousand instructors

with their thousands and thousands of courses.

So this is a very good use case

on how to load the data in a Master Detail View.

Now let's discuss the idea of a fetch type.

So when you define the mapping relationship

between two entities or classes,

you can specify the fetch type of being

eager or lazy.

So in this example here,

we have an instructor

and remember an instructor has a list of courses.

Here I'll have the at one to many

and then I'll set up the fetch type.

I'll say fetch equals fetch type dot lazy.

So in that case, they'll actually load

the instructor first and then they'll

only load the courses on demand.

They'll load the courses in a lazy fashion

at a later time.

Now you may wonder, hey well we've used some of these

relationships before when we didn't

specify a fetch type.

Well in that case,

they're simply making use of the defaults.

So here's a list of defaults

for the different relationship types.

So for one to one, the default type is eager.

For one to many, the default type is lazy.

And for many to one, it is eager.

And for many to many, the default is lazy.

So those are the default types if you don't specify

a fetch type when you actually set up the relationship.

Now you can also override the default fetch type.

We can simply make use of an example here

where we have this many to one, the default type is eager.

But we don't want to use eager

we're gonna actually override that value and you simply just

be explicit.

You say many to one, fetch equals fetch dot lazy.

That will actually override the default fetch type.

Pretty straight forward.

Alrighty, so a bit more about lazy loading

so we're kind of digging in here

so when you lazy load, the data is only retrieved on demand.

But they caveat here is that, this requires an open

hibernate session so you basically need a connection

to the database to retrieve data at a later time.

But then you're probably wondering

well what happens when the hibernating session is closed?

Well if you attempt to retrieve that lazy data

once the session's closed then

hibernate will actually throw an exception

so you really have to kind of watch out for this.

But don't worry, in the following videos

we'll actually write code and we'll break it on purpose.

We'll write some bad code to actually throw this exception.

And then I'll show you how we can actually

resolve this issue and work around it.

So to retrieve the lazy data remember,

you need to have an open hibernate session.

So you have different options on retrieving the lazy data.

So option one is that you can simply do a session dot get

and then call the appropriate getter methods

and then in option two you can make use of the hibernate

query language using h q l

and I'll show you both of those

options in the following videos.

Now there's a lot of other techniques available

but the two above are the most commonly used

on real-world, real-time projects.

Alrighty, so let's go ahead and move into eclipse.

We'll actually write some code using eager

loading and lazy loading

and we'll get it all running locally

on our computer

