USE [cathy]
GO
/****** Object:  Table [dbo].[image]    Script Date: 06/17/2019 15:10:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[image](
	[iid] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[iname] [varchar](32) NOT NULL,
	[ifilepath] [varchar](400) NOT NULL,
	[iurl] [varchar](40) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[iid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[attachment]    Script Date: 06/17/2019 15:10:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[attachment](
	[aid] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[aname] [varchar](32) NOT NULL,
	[afilepath] [varchar](400) NOT NULL,
	[aurl] [varchar](40) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[aid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TUser]    Script Date: 06/17/2019 15:10:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TUser](
	[userid] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[loginname] [varchar](20) NOT NULL,
	[password] [varchar](40) NULL,
	[username] [varchar](20) NOT NULL,
	[createtime] [varchar](40) NULL,
	[lastLoginTime] [varchar](40) NULL,
	[readAndWriteRight] [smallint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[userid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tmodule]    Script Date: 06/17/2019 15:10:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tmodule](
	[tmid] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[tmname] [varchar](40) NOT NULL,
	[tmcomment] [varchar](400) NULL,
PRIMARY KEY CLUSTERED 
(
	[tmid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[mcolumn]    Script Date: 06/17/2019 15:10:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[mcolumn](
	[mcid] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[mcname] [varchar](40) NOT NULL,
	[mccomment] [varchar](400) NULL,
	[tmid] [numeric](18, 0) NULL,
	[route_path] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[mcid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[article]    Script Date: 06/17/2019 15:10:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[article](
	[aid] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[title] [varchar](40) NOT NULL,
	[tag] [varchar](100) NULL,
	[author] [varchar](32) NULL,
	[acomment] [varchar](400) NULL,
	[createtime] [varchar](100) NULL,
	[bodypart] [image] NULL,
	[images] [varchar](800) NULL,
	[attachments] [varchar](800) NULL,
	[mcid] [numeric](18, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[aid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Default [DF__article__title__4D94879B]    Script Date: 06/17/2019 15:10:17 ******/
ALTER TABLE [dbo].[article] ADD  DEFAULT ('文章名称') FOR [title]
GO
/****** Object:  Default [DF__mcolumn__mcname__47DBAE45]    Script Date: 06/17/2019 15:10:17 ******/
ALTER TABLE [dbo].[mcolumn] ADD  DEFAULT ('栏目名称') FOR [mcname]
GO
/****** Object:  Default [DF__tmodule__tmname__4316F928]    Script Date: 06/17/2019 15:10:17 ******/
ALTER TABLE [dbo].[tmodule] ADD  DEFAULT ('模块名称') FOR [tmname]
GO
/****** Object:  Default [DF__TUser__readAndWr__5AEE82B9]    Script Date: 06/17/2019 15:10:17 ******/
ALTER TABLE [dbo].[TUser] ADD  DEFAULT ((1)) FOR [readAndWriteRight]
GO
/****** Object:  ForeignKey [FK_MCID]    Script Date: 06/17/2019 15:10:17 ******/
ALTER TABLE [dbo].[article]  WITH CHECK ADD  CONSTRAINT [FK_MCID] FOREIGN KEY([mcid])
REFERENCES [dbo].[mcolumn] ([mcid])
GO
ALTER TABLE [dbo].[article] CHECK CONSTRAINT [FK_MCID]
GO
/****** Object:  ForeignKey [FK_TMID]    Script Date: 06/17/2019 15:10:17 ******/
ALTER TABLE [dbo].[mcolumn]  WITH CHECK ADD  CONSTRAINT [FK_TMID] FOREIGN KEY([tmid])
REFERENCES [dbo].[tmodule] ([tmid])
GO
ALTER TABLE [dbo].[mcolumn] CHECK CONSTRAINT [FK_TMID]
GO
