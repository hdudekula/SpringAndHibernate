-----------------------------------------
BI-DIRECTIONAL ONE-ONE MAPPING
-----------------------------------------

we'll cover Hibernate one-to one bi-directional.

So, we currently have a uni-directional mapping

between our Instructor and our InstructorDetail

and that's working just fine for us.

We covered all of that in the previous video

but now we have a new use case.

Basically we wanna load an InstructorDetail object

and then we'd like to get the associated Instructor

for that detail object

but we can't really do this

with our current uni-directional relationship,

so right now we can only start with Instructor

and then move to InstructorDetail,

we can't go the other way.

With uni-directional it's really just a one-way street.

But we can actually solve this

by making use of a bi-directional relationship.

So what we can do is start with the InstructorDetail

and then we can actually make it back

to the instructor

and also since we already have

the previous uni-directional relationship in place,

we effectively have bi-directional now,

so now this is a two-way street,

so we can start on any side.

We can start with instructor,

get the InstructorDetail

or start with InstructorDetail

and make it back to the instructor.

So, the nice thing about using bi-directional

is that we have some good news.

We can actually keep our existing database schema

so this is really cool so there's really no changes required

to our database setup,

so we can continue to use the Instructor,

InstructorDetail table

with the foreign keys that we set up

in the previous video.

So, really the only thing that we have to change now

is to simple update the Java code

and we'll cover that part in this video.

Alrighty, so here's our development process,

so we basically need to make some updates

to the InstructorDetail class.

We'll need to add a new field to reference the Instructor

and also add the appropriate getter/setter methods

for Instructor and then we need to add

a OneToOne annotation such that we can point back

to the original Instructor

and then finally, we'll kind of pull it all together

by creating a main application

and we'll test all of this out.

Alrighty, so let's start with step 1.1,

adding a new field to reference Instructor.

So, here's our class here InstructorDetail

and we have the code in place right now

for adding that new field,

so we have a new field named Instructor.

Alright, so step 1.2 add in getter/setter methods

for Instructor, so here we just have

a getter and a setter.

Again, there's no rocket science here.

Basically we can generate this with Eclipse

but the key thing here is that we can call the setter method

for adding an Instructor or setting the instructor,

use the getter method for getting the associated Instructor

with this given InstructorDetail instance.

Now we're moving ahead to step 1.3.

This is where we add the OneToOne annotation.

So, note here on our field for Instructor,

we add the @OneToOne

and then we have a new entry here

that's a little interesting.

We say mappedBy InstructorDetail.

So, what exactly does this refer to

or what does this mean?

Well, this basically refers to the InstructorDetail property

in the Instructor class.

So, what we're telling Hibernate

is that this Instructor field

is actually mapped by the InstructorDetail property

in the Instructor class.

Alright, so that's kind of the mappedBy.

Let's kind of dig into this a little further.

So, a bit more on mappedBy.

So, we have this reference here for mappedBy.

That's in our InstructorDetail class here.

So again, the mappedBy tells Hibernate

to look at the InstructorDetail property

in the Instructor class

so Hibernate can actually use the information

from the Instructor class's join column

to figure out how to find the associated Instructor,

alright, so you're basically telling Hibernate

hey, this field Instructor in InstructorDetail

it's mappedBy InstructorDetail.

Hibernate will go figure that out,

look at the foreign key relationship

and match everything up,

so effectively Hibernate can use this information

to find out how these two items are linked up

and also finding the appropriate Instructor

for this given InstructorDetail.

Alrighty, so that's the mappedBy.

Now, the other thing here is cascading,

so we'll add support for cascading,

so this new entry that I just added here,

cascade equals CascadeType.ALL,

so remember from the previous videos,

this will actually cascade all operations

to the associated Instructor.

So, if I load an InstructorDetail

then if I wanna delete that InstructorDetail,

this will also cascade the delete operation

to that given Instructor

and remember, you have fine grained control

over the cascading types

so if you don't want to cascade all,

you can choose the appropriate cascade types

that you'd like to use for your given use case.

Alright, so we can kind of wrap it up here

and we can wrap it up by creating a main app,

that's our step two.

So, basically what we're gonna do here

is that we're gonna go through

and actually get the InstructorDetail object

from the database,

so I'll set up theId equals one,

that's whatever the ID is

or primary key for that given InstructorDetail object

and then I'll go and grab that InstructorDetail

from the database,

so I do a session.get InstructorDetail.class

and I pass in a reference to theId.

Then what I'll do is kind of move forward here

and I'll print out the details,

so I'll say system.out.print line,

tempInstructorDetail.

And then we'll go through and print out

the associated Instructor.

So, here I'd do a system.out.print line,

and I'll say tempInstructorDetail.getInstructor.

So, remember, now we have this bi-directional relationship,

so by going to the InstructorDetail,

I can get back to the actual Instructor

and print that information out.

So, this is great, so this kind of meets our objectives,

kind of fulfills our requirement

of having this bi-directional relationship

between Instructor and InstructorDetail.

Alrighty, so this is some good information.

What we're gonna do in the next video,

jump into Eclipse and then we'll write this code

and we'll test it out,