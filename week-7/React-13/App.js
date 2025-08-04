import React, { useState } from 'react';
import CourseDetails from './Components/CourseDetails';
import BookDetails from './Components/BookDetails';
import BlogDetails from './Components/BlogDetails';
import './App.css';

function App() {
  const [showCourses, setShowCourses] = useState(true);
  const [showBooks, setShowBooks] = useState(true);
  const [showBlogs, setShowBlogs] = useState(true);

  return (
    <div className="app-container">
      {showCourses && <CourseDetails />}
      {showBooks ? <BookDetails /> : null}
      {showBlogs && <BlogDetails />}
    </div>
  );
}

export default App;
