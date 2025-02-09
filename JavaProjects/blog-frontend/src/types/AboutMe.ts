export interface AboutMe {
  id?: number;
  full_name: string;
  nick_name?: string;
  profile_picture_url?: string;
  short_bio: string;
  detailed_bio: string;
  birth_date?: string;
  hometown?: string;
  current_location?: string;
  occupation?: string;
  hobbies?: string;
  contact_email?: string;
  personal_website_url?: string;
  social_media_links?: {
    [key: string]: string;
  };
  skills?: string;
  education?: string;
  awards_and_achievements?: string;
  created_at?: string;
  updated_at?: string;
}
