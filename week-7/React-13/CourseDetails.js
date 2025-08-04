import React from 'react';

const CourseDetails = () => {
  const courses = [
    { name: 'Angular', date: '4/5/2021' },
    { name: 'React', date: '6/3/20201' }
  ];

  let content;
  if (courses.length > 0) {
    content = (
      <div className="column">
        <h2>Course Details</h2>
        {courses.map((course, index) => (
          <div key={index}>
            <h3>{course.name}</h3>
            <p>{course.date}</p>
          </div>
        ))}
      </div>
    );
  } else {
    content = <p>No courses available.</p>;
  }

  return content;
};

export default CourseDetails;
