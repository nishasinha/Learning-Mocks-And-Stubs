# Creating Java Stub class for testing

Looking at this commit, we can understand:

- TodoBusinessImpl is the main business class.
- TodoService is the service class which contacts external world.

Now to test the TodoBusinessImpl, need TodoService as a dependency
which contacts to external world and hence a real test is not possible.

So, to test such classes with such dependencies, there is java way of
testing:

- Create the stub class TodoService Stub implementing dependency class so that it has 
all the methods in the dependency class.
- Use the stub class in test as used in TodoBusinessImplStubTest.java

The problem is:
- maintaining the stub class, every update in main class should also be
 done in stub class.
- Dynamic behavior: the stub class is static, to get values based on
 scenarios, all the scenario logic should be added in stub class which makes 
 it complex.


# Intro to testing using Mockito Library

Since there were issues in manually created stubbed class, there is 
"mockito library" that allows creation of dependency class objects 
dynamically and stub behaviour on them using when and 
thenReturn methods.

Look into class TodoBusinessImplMockitoTest.java, how it creates the 
dependency object TodoService.

So, 
- mock allows creating dummy object.
- all methods are available on mock object.
- Unless specified they return default values, like empty list.
(NICE MOCK BEHAVIOUR, easy mock did not have this by default but mockito has.)
- The behaviour can be stubbed using "when" and "thenReturn" methods.


### Testing using Mockito

It can test any class in Java except:
  - final classes
  - anonymous classes
  - primitive types
  
Also, when the parameter passed to any stubbed method is not defined, 
we can use Argument Matchers from matchers like

- anyInt() anyByte() anyObject() etc. 
and then return the value expected.
