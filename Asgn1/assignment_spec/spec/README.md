# Assignment 1
##*Vandy Food Finder*
Team Members: Aston King, Cameron Ridgewell, Fangzhou Sun, Nathan Walker, Will Pascucci

## Overview

As the Vanderbilt campus grows and changes with the construction and renovation of dorms and buildings, many students, faculty, and employees are unaware of the food options available to them and when they are available. Vandy Food Finder will help everyone at Vanderbilt find a convenient meal whenever is best for the user and localize this search process to one app.

Vandy Food Finder will provide an intuitive interface that allows users to find which food locations are closest and open for operation. The entire Vanderbilt community runs on a widely varying schedule and can use this app to find the most convenient places to eat at any time of day.


## User Stories

1. I want to be able to see, at a glance, the closest places where I can use my meal plan.
2. I would like to be able to filter (on/off-campus, meal plan/money, open now, type of food, delivery optionÉ) and sort (distance, price, closing soonÉ)  a list of Vanderbilt dining locations.
3. As someone who doesnÕt like cafeteria food, I would like to know which restaurants are on the vandy card.
4. As a busy student, I would like to check what food delivery options are open. 
5. As a new student, I want an easy way to determine what my dining options are.
6. As someone who tends to eat late dinners, I want to know what dining locations are available at when I check the app late at night (ex. 10pm).
7. As someone who likes to plan their day ahead of time, I would like to look up when food locations will be open at a certain later date/time.

## Possibly Helpful Technical Information

1. Campus and Nashville Food locations
    http://campusdining.vanderbilt.edu/about/hours-of-operation/whats-open/
    http://campusdining.vanderbilt.edu/locations/
    http://campusdining.vanderbilt.edu/taste-of-nashville/

2. The Parse platform provides a complete backend solution for server and datebase. You can refer to ParseÕs Android guide for details.
    https://parse.com/docs/android_guide


## Evaluation Rubrics

There are 100 total points for this application.

0. (15 pts) - I want to be able to see, at a glance, the closest places where I can use my meal plan. Evaluation process:
    - list view sorted by distance

1. (20 pts) - I would like to be able to filter (on/off-campus, meal plan/money, open now, type of food, delivery optionÉ) and sort (distance, price, closing soonÉ)  a list of Vanderbilt dining locations. Evaluation process:
    - (15 pts) A diversity of filter and sort options
    - (5 pts) Uncluttered implementation

2. (5 pts) - As someone who doesnÕt like cafeteria food, I would like to know which restaurants are on the vandy card. Evaluation process:
    - list view filtered by on/off campus
    - (5 pts) Information about payment options present in database

3. (5 pts) - As a busy student, I would like to check what food delivery options are open. Evaluation process:
    - (5 pts) List of food locations that deliver at the current time

4. (10 pts) - As a new student, I want an easy way to determine what all my dining options are. Evaluation process:
    - (10 pts) Basic info page about each location (w/ open/close times)
    - Unfiltered list view

5. (10 pts) - As someone who tends to eat late dinners, I want to know what dining locations are available at when I check the app late at night (ex. 10pm). Evaluation process:
    - (3 pts) List view
    - (3 pts) Filter and sort options
    - (4 pts) Basic Information, like type of food, payment options, close time

6. (5 pts) - As someone who likes to plan their day ahead of time, I would like to look up when food locations will be open at a certain later date/time. Evaluation process:
    - (5 pts) Input a time and see a list of locations are open at that time

7. (30 pts) Uses consistent code style with simple, effective uses of Java for a highly readable, adaptable code base. Evaluation process:
    - (10 pts) Orthogonal classes and methods to minimize unnecessary code.
    - (10 pts) Simple populating and filtering of list views to minimize response times
    - (10 pts) Efficient handling of distance to locations using phoneÕs location data.
