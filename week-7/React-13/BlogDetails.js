import React from 'react';

const BlogDetails = () => {
  const showBlog = true; // Demonstrates inline conditional rendering

  return showBlog && (
    <div className="column">
      <h2>Blog Details</h2>
      <div>
        <h3>React Learning</h3>
        <p><strong>Stephen Biz</strong></p>
        <p>Welcome to learning React!</p>
      </div>
      <div>
        <h3>Installation</h3>
        <p><strong>Schwezdneier</strong></p>
        <p>You can install React from npm.</p>
      </div>
    </div>
  );
};

export default BlogDetails;
