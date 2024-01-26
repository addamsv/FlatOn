export const Pagination = (props: {
  pages: any[];
  page: number;
  pageChangeHandler: (pageNum: number) => void;
}) => {
  return (
    <>
      {props.pages.length
        ? props.pages.map((pageNum: number) => (
            <span
              style={{
                border:
                  props.page === pageNum ? "#777 solid 1px" : "#aaa solid 1px",
                borderRadius: 3,
                margin: 3,
                padding: 3,
                cursor: "pointer",
              }}
              onClick={() => props.pageChangeHandler(pageNum)}
            >
              {pageNum}
            </span>
          ))
        : undefined}
    </>
  );
};
