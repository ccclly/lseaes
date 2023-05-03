create table course
(
    id          int auto_increment
        primary key,
    name        varchar(100)                         not null,
    description varchar(2000)                       null,
    img_name    varchar(200)                        null,
    author_id   int                                 null,
    create_at   timestamp default CURRENT_TIMESTAMP null,
    update_at   timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
);

create table chapter
(
    id        int auto_increment
        primary key,
    name      varchar(100)                         not null,
    course_id int                                 null,
    order_num int                                 null,
    create_at timestamp default CURRENT_TIMESTAMP null,
    update_at timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint chapter_ibfk_1
        foreign key (course_id) references course (id)
);

create index course_id
    on chapter (course_id);

create table exam
(
    id            int auto_increment
        primary key,
    name          varchar(100)                         not null,
    total_time    int       default 0                 not null,
    repository_id int                                 not null,
    count         int                                 not null,
    create_at     timestamp default CURRENT_TIMESTAMP null,
    update_at     timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
);

create table exam_course
(
    id        int auto_increment
        primary key,
    exam_id   int not null,
    course_id int not null
);

create index course_id
    on exam_course (course_id);

create index exam_id
    on exam_course (exam_id);

create table lesson
(
    id         int auto_increment
        primary key,
    name       varchar(100)                         not null,
    chapter_id int                                 null,
    course_id  int                                 null,
    order_num  int                                 null,
    vedio_name varchar(200)                        null,
    create_at  timestamp default CURRENT_TIMESTAMP null,
    update_at  timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint lesson_ibfk_1
        foreign key (chapter_id) references chapter (id)
);

create index chapter_id
    on lesson (chapter_id);

create table notice
(
    id          int auto_increment
        primary key,
    title       varchar(800)                        not null,
    description varchar(10000)                      not null,
    create_at   timestamp default CURRENT_TIMESTAMP null,
    update_at   timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
);

create table paper
(
    id         int auto_increment
        primary key,
    exam_id    int                                 not null,
    user_id    int                                 not null,
    name       varchar(100)                        not null,
    state      int       default 1                 not null comment '试卷状态',
    user_score double                              null,
    total_time int       default 0                 not null comment '考试时长',
    create_at  timestamp default CURRENT_TIMESTAMP null,
    update_at  timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
);

create index exam_id
    on paper (exam_id);

create index user_id
    on paper (user_id);

create table paper_question
(
    id            int auto_increment
        primary key,
    paper_id      int                  not null,
    question_id   int                  not null,
    question_type int                  not null comment '题目类型',
    answered      tinyint(1) default 0 not null comment '是否已答',
    is_right      tinyint(1) default 0 not null comment '是否答对',
    sort          int        default 0 not null
);

create index paper_id
    on paper_question (paper_id);

create index question_id
    on paper_question (question_id);

create table paper_question_answer
(
    id          int auto_increment
        primary key,
    paper_id    int                  not null,
    question_id int                  not null,
    answer_id   int                  not null,
    is_right    tinyint(1) default 0 not null comment '是否答对',
    checked     tinyint(1) default 0 not null,
    sort        int        default 0 not null,
    abc         varchar(64)          not null
);

create index answer_id
    on paper_question_answer (answer_id);

create index paper_id
    on paper_question_answer (paper_id);

create index question_id
    on paper_question_answer (question_id);

create table problem
(
    id               int auto_increment
        primary key,
    name             varchar(300)                        not null,
    type             int                                 null,
    choice_a         varchar(300)                        null,
    choice_a_is_true tinyint(1)                          null,
    choice_b         varchar(300)                        null,
    choice_b_is_true tinyint(1)                          null,
    choice_c         varchar(300)                        null,
    choice_c_is_true tinyint(1)                          null,
    choice_d         varchar(300)                        null,
    choice_d_is_true tinyint(1)                          null,
    analysis_desc    varchar(500)                        null,
    appear_count     int                                 null,
    right_ans_count  int                                 null,
    author_id        int                                 null,
    create_at        timestamp default CURRENT_TIMESTAMP null,
    update_at        timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
);

create table exam_problem
(
    id         int auto_increment
        primary key,
    problem_id int                                 not null,
    exam_id    int                                 not null,
    create_at  timestamp default CURRENT_TIMESTAMP null,
    update_at  timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint exam_problem_ibfk_1
        foreign key (problem_id) references problem (id),
    constraint exam_problem_ibfk_2
        foreign key (exam_id) references exam (id)
);

create index exam_id
    on exam_problem (exam_id);

create index problem_id
    on exam_problem (problem_id);

create table question
(
    id            int auto_increment comment '题目ID'
        primary key,
    type          int                                 not null comment '题目类型',
    name          varchar(300)                        not null,
    img_name      varchar(200)                        null,
    analysis_desc varchar(500)                        null,
    create_at     timestamp default CURRENT_TIMESTAMP null,
    update_at     timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
)
    comment '试题主表';

create table question_answer
(
    id          int auto_increment
        primary key,
    question_id int                  null comment '问题ID',
    is_right    tinyint(1) default 0 not null comment '是否正确',
    img_name    varchar(200)         null,
    name        varchar(300)         not null
)
    comment '试题答案选项';

create table question_repository
(
    id            int auto_increment
        primary key,
    question_id   int not null,
    repository_id int not null
)
    comment '试题题库关联';

create index question_id
    on question_repository (question_id);

create index repository_id
    on question_repository (repository_id);

create table recode_lesson
(
    id        int auto_increment
        primary key,
    process   int default 0 not null,
    lesson_id int           not null,
    course_id int           not null,
    user_id   int           not null
);

create index course_id
    on recode_lesson (course_id);

create index lesson_id
    on recode_lesson (lesson_id);

create index user_id
    on recode_lesson (user_id);

create table repository
(
    id        int auto_increment
        primary key,
    title     varchar(255)                        not null,
    create_at timestamp default CURRENT_TIMESTAMP null,
    update_at timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
);

create table repository_exam
(
    id            int auto_increment
        primary key,
    exam_id       int not null,
    repository_id int not null
);

create index exam_id
    on repository_exam (exam_id);

create index repository_id
    on repository_exam (repository_id);

create table rule
(
    id          int auto_increment
        primary key,
    title       varchar(800)                        not null,
    description varchar(10000)                      not null,
    create_at   timestamp default CURRENT_TIMESTAMP null,
    update_at   timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
);

create table user
(
    id        int auto_increment
        primary key,
    name      varchar(30)                         not null,
    password  varchar(50)                         not null,
    grade     varchar(30)                         null,
    college   varchar(30)                         null,
    major     varchar(30)                         null,
    user_type int                                 not null,
    create_at timestamp default CURRENT_TIMESTAMP null,
    update_at timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
);

create table user_exam
(
    id        int auto_increment
        primary key,
    user_id   int                                 not null,
    exam_id   int                                 not null,
    score     double                              null,
    create_at timestamp default CURRENT_TIMESTAMP null,
    update_at timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint user_exam_ibfk_1
        foreign key (user_id) references user (id),
    constraint user_exam_ibfk_2
        foreign key (exam_id) references exam (id)
);

create index exam_id
    on user_exam (exam_id);

create index user_id
    on user_exam (user_id);

create table user_exam_option
(
    id               int auto_increment
        primary key,
    user_id          int        null,
    exam_id          int        null,
    problem_id       int        null,
    choice_a_is_true tinyint(1) null,
    choice_b_is_true tinyint(1) null,
    choice_c_is_true tinyint(1) null,
    choice_d_is_true tinyint(1) null,
    constraint user_exam_option_ibfk_1
        foreign key (user_id) references user (id),
    constraint user_exam_option_ibfk_2
        foreign key (exam_id) references exam (id),
    constraint user_exam_option_ibfk_3
        foreign key (problem_id) references problem (id)
);

create index exam_id
    on user_exam_option (exam_id);

create index problem_id
    on user_exam_option (problem_id);

create index user_id
    on user_exam_option (user_id);


