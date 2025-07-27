import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false
    };
  }

  // Step 6: loadPosts method
  loadPosts = () => {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => {
        if (!response.ok) {
          throw new Error("Failed to fetch posts");
        }
        return response.json();
      })
      .then(data => {
        const loadedPosts = data.map(post => new Post(post.userId, post.id, post.title, post.body));
        this.setState({ posts: loadedPosts });
      })
      .catch(error => {
        console.error("Error loading posts:", error);
        this.setState({ hasError: true });
      });
  };

  // Step 7: componentDidMount to call loadPosts
  componentDidMount() {
    this.loadPosts();
  }

  // Step 9: Catching errors in rendering lifecycle
  componentDidCatch(error, info) {
    alert("An error occurred: " + error);
    console.error("Error info:", info);
  }

  // Step 8: Render method
  render() {
    const { posts, hasError } = this.state;

    if (hasError) {
      return <h2>Error loading posts. Please try again later.</h2>;
    }

    return (
      <div style={{ padding: '20px' }}>
        <h1>Blog Posts</h1>
        {posts.length === 0 ? (
          <p>Loading posts...</p>
        ) : (
          posts.map(post => (
            <div key={post.id} style={{ marginBottom: '20px' }}>
              <h2>{post.title}</h2>
              <p>{post.body}</p>
            </div>
          ))
        )}
      </div>
    );
  }
}

export default Posts;
