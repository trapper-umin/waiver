
CREATE TABLE person(
  person_id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY ,

  username varchar(255) NOT NULL UNIQUE CHECK ( length(username)>3 ),
  password varchar(255) NOT NULL CHECK ( length(password)>3 ),
  role varchar(255) NOT NULL CHECK ( length(role)>3 )
);

-- person-details (one-to-one)
-- (points, missed_tasks, completed_tasks, created_at, updated_at)  must be create together with USER
-- (name, age, email) can update via PATCH or PUT after create USER
CREATE TABLE details(
  details_id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY ,
  person_id int UNIQUE REFERENCES person(person_id),

  name varchar(255) CHECK ( length(name)>3 ),
  age int CHECK ( age>1 AND age<125),
  email varchar(255) CHECK ( length(email)>3 ),

  points int NOT NULL DEFAULT 0,
  missed_tasks int NOT NULL DEFAULT 0,
  completed_tasks int NOT NULL DEFAULT 0,
  created_at timestamp NOT NULL,
  updated_at timestamp NOT NULL
);