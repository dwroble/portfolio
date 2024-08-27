using EFCore_Demo.DBContext;
using EFCore_Demo.Interfaces;
using EFCore_Demo.Models;

namespace EFCore_Demo.Services
{
    public class ProgramService : IProgramService
    {

        private readonly IAppService _service;

        public ProgramService(IAppService appService)
        {
            _service = appService;
            using (var context = new AppDbContext())
            {
                if (context.Database.EnsureCreated())
                {
                    Console.WriteLine("Creating Database Tables!");
                    CreateStaticData();
                }
            }
        }

        public Blog CreateBlog(Blog blog)
        {
            Blog retBlog = _service.CreateBlog(blog);
            return retBlog;
        }

        public IEnumerable<Blog> GetBlogList()
        {
            IEnumerable<Blog> blogList = _service.GetBlogList();
            return blogList;
        }

        public Blog GetBlogByID(int id)
        {
            Blog blog = _service.GetBlogByID(id) ?? new();
            return blog;
        }

        public Comment CreateCommentOnBlog(Comment comment)
        {
            Comment retComment = _service.CreateCommentOnBlog(comment);
            return retComment;
        }

        public IEnumerable<Comment> GetAllCommentsInBlogByBlogID(int blogID)
        {
            IEnumerable<Comment> commentsList = _service.GetAllCommentsInBlogByBlogID(blogID);
            return commentsList;
        }

        // For initialization of database values
        private static void CreateStaticData()
        {
            using (var context = new AppDbContext())
            {
                Blog blog1 = new Blog() { 
                    Title = "Lorem ipsum odor amet", 
                    Content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Phasellus augue ipsum, egestas vitae eros tempus, commodo tincidunt nulla. Duis vitae posuere felis. " +
                        "Nulla suscipit nisi in pulvinar tempor. Morbi tincidunt, quam nec molestie sollicitudin, leo purus vulputate nunc, " +
                        "et euismod sapien nunc aliquam ipsum. Sed quam nisi, accumsan non purus sed, interdum bibendum libero. Sed vitae orci " +
                        "facilisis, hendrerit risus vitae, fringilla sapien. Proin imperdiet felis ut hendrerit porttitor.", 
                    DateCreated = DateTime.Now, 
                };
                Blog blog2 = new Blog() { 
                    Title = "Sed nulla ex", 
                    Content = "Sed nulla ex, ultricies vel elit ut, rutrum ultrices quam. " +
                        "Etiam velit nisl, faucibus nec magna sit amet, commodo accumsan eros. " +
                        "Praesent convallis ex orci, quis malesuada magna suscipit id. " +
                        "Donec ornare ex eu sem vulputate, nec luctus sapien iaculis. Aenean ut augue purus. " +
                        "Integer molestie risus eu feugiat fringilla. Maecenas iaculis, turpis et fermentum venenatis, " +
                        "augue mauris tristique arcu, at porta turpis nunc eu tortor.", 
                    DateCreated = DateTime.Now, 
                };

                Comment cmnt1 = new Comment() { 
                    Content = "Class sapien senectus convallis rutrum amet condimentum fringilla feugiat dictum.", 
                    DateCreated = DateTime.Now, 
                    BlogID = 1 
                };
                Comment cmnt2 = new Comment() { 
                    Content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", 
                    DateCreated = DateTime.Now, 
                    BlogID = 1 
                };
                Comment cmnt3 = new Comment() { 
                    Content = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.", 
                    DateCreated = DateTime.Now, 
                    BlogID = 2 
                };
                Comment cmnt4 = new Comment() { 
                    Content = "Nulla curabitur eleifend luctus, malesuada nec facilisi.", 
                    DateCreated = DateTime.Now, 
                    BlogID = 2 
                };
                Comment cmnt5 = new Comment() { 
                    Content = "Dui felis fringilla quis ultrices id.", 
                    DateCreated = DateTime.Now, 
                    BlogID = 2 
                };

                List<Comment> commentsList1 = [cmnt1, cmnt2];
                List<Comment> commentsList2 = [cmnt3, cmnt4, cmnt5];

                context.Blog.Add(blog1);
                context.Blog.Add(blog2);

                foreach (Comment comment in commentsList1)
                {
                    context.Comments.Add(comment);
                }

                foreach (Comment comment in commentsList2)
                {
                    context.Comments.Add(comment);
                }

                context.SaveChanges();
            }
        }
    }
}
