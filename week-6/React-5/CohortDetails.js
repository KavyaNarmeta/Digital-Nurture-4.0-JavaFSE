// CohortDetails.js

import React from 'react';
import styles from './CohortDetails.module.css';

const CohortDetails = ({ cohorts }) => {
  return (
    <div>
      <h2>Cohorts Details</h2>
      {cohorts.map((cohort, index) => (
        <div key={index} className={styles.box}>
          <h3 className={cohort.status === 'Ongoing' ? styles.greenTitle : styles.blueTitle}>
            {cohort.name}
          </h3>
          <dl>
            <dt>Started On</dt>
            <dd>{cohort.startDate}</dd>

            <dt>Current Status</dt>
            <dd>{cohort.status}</dd>

            <dt>Coach</dt>
            <dd>{cohort.coach}</dd>

            <dt>Trainer</dt>
            <dd>{cohort.trainer}</dd>
          </dl>
        </div>
      ))}
    </div>
  );
};

export default CohortDetails;
